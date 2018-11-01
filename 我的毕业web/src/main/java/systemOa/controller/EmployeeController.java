package systemOa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import systemOa.bean.Attendance;
import systemOa.bean.Employee;
import systemOa.bean.MessageCount;
import systemOa.bean.OperationLog;
import systemOa.service.IAttendanceService;
import systemOa.service.IEmployeeService;
import systemOa.service.IMessageCountService;
import systemOa.service.IOperationLogService;
import systemOa.useClass.FrequentMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    @Qualifier("employeeService")
    private IEmployeeService iEmployeeService;

    public IEmployeeService getiEmployeeService() {
        return iEmployeeService;
    }

    public void setiEmployeeService(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @Autowired
    @Qualifier("operationLogService")
    private IOperationLogService iOperationLogService;

    public IOperationLogService getiOperationLogService() {
        return iOperationLogService;
    }

    public void setiOperationLogService(IOperationLogService iOperationLogService) {
        this.iOperationLogService = iOperationLogService;
    }

    @Autowired
    @Qualifier("attendanceService")
    private IAttendanceService iAttendanceService;

    public IAttendanceService getiAttendanceService() {
        return iAttendanceService;
    }

    public void setiAttendanceService(IAttendanceService iAttendanceService) {
        this.iAttendanceService = iAttendanceService;
    }

    @Autowired
    @Qualifier("messageCountService")
    private IMessageCountService iMessageCountService;

    public IMessageCountService getiMessageCountService() {
        return iMessageCountService;
    }

    public void setiMessageCountService(IMessageCountService iMessageCountService) {
        this.iMessageCountService = iMessageCountService;
    }

    //封装的日志登记方法
    public void loadLogs(String opeAction, Employee employee){
        Date opeTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(opeTime);
        String opeAll = employee.getDepartment()+"的"+employee.getName()+"在"+dateString+"进行了"
                +opeAction+"操作";
        OperationLog operationLog = new OperationLog(employee.getName(),opeTime,opeAction,opeAll);
        iOperationLogService.insertLog(operationLog);
    }

    //封装的页面加载方法
    public PageInfo loadEmployees(Integer pn, List<Employee> employees){
        int pageSize = 1000;
        //pageSize为总的记录长度
        PageHelper.startPage(pn, pageSize);
        PageInfo page = new PageInfo(employees, pageSize);
        return page;
    }


    @RequestMapping("LoginCheck.do")
    public String loginCheck(Employee employee, Model model, HttpSession session){
        employee = iEmployeeService.LoginCheck(employee.getEmployeeId(),employee.getPassword());
        if(employee!=null){
            String opeAction = "登录";
            loadLogs(opeAction,employee);
            session.setAttribute("employee",employee);
            System.out.println("####################"+employee.getAuthority());
            Employee employee1 = (Employee)session.getAttribute("employee");
            System.out.println(employee1.getAuthority());
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            String year = String.valueOf(cal.get(cal.YEAR));
            int month = cal.get(cal.MONTH)+1;
            String monthId = year+month;
            int monthDay = cal.get(cal.DAY_OF_MONTH);
            int day = cal.get(cal.DAY_OF_WEEK)-1;

            String weekDay = null;
            switch (day){
                case 1:weekDay="星期一";break;
                case 2:weekDay="星期二";break;
                case 3:weekDay="星期三";break;
                case 4:weekDay="星期四";break;
                case 5:weekDay="星期五";break;
                case 6:weekDay="星期六";break;
                case 7:weekDay="星期日";break;
            }
            Attendance attendance = iAttendanceService.selectExistStatus(monthId,monthDay,employee.getEmployeeId());
            if(attendance==null){
                Attendance attendance1 = new Attendance(monthId,monthDay,weekDay,employee.getEmployeeId(),
                        employee.getDepartment(),employee.getName(),
                        null,null,0,0);
                iAttendanceService.insertNewAttendance(attendance1);
                session.setAttribute("attendance",attendance1);
            }
            else{
                session.setAttribute("attendance",attendance);
            }
            MessageCount messageCount = iMessageCountService.selectAllMessage();
            session.setAttribute("messageCount",messageCount);
            return "WEB-INF/employee/employeeHeader.jsp";
        }else{

            model.addAttribute("msg", "用户名或密码错误，请重新登录！");
            return "index.jsp";
        }

    }

    //查询所有员工信息
    @RequestMapping("selectAllEmployees.do")
    public String selectAllEmployees(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model,HttpSession session){
        List<Employee> employees = iEmployeeService.selectAllEmployees();
        PageInfo page = loadEmployees(pn,employees);
        model.addAttribute("pageInfo", page);
        Employee employee = (Employee) session.getAttribute("employee");
        if(employee.getAuthority()==2){
            return "WEB-INF/employee/manager/PersonnelManager/personnel.jsp";
        }
        else{
            return "WEB-INF/employee/personnel/PersonnelManager/personnel.jsp";
        }

    }



    //添加新员工
    @RequestMapping("addEmployee.do")
    public String insertEmployee(Employee employee,HttpSession session,Model model){
        Employee employee1 =(Employee) session.getAttribute("employee");
        employee.setDepartment(employee1.getDepartment());
        employee.setAuthority(employee1.getAuthority()+1);
        int i = iEmployeeService.insertEmployee(employee);
        if(i>0){
            //日志登记
            String opeAction = "添加新员工";
            loadLogs(opeAction,employee1);
            //列表刷新动作
            Integer pn = 1;
            List<Employee> employees = iEmployeeService.selectAllEmployees();
            PageInfo page = loadEmployees(pn,employees);
            model.addAttribute("pageInfo", page);
            return "WEB-INF/employee/manager/PersonnelManager/personnel.jsp";
        }else{
            return "error.jsp";
        }

    }

    //删除员工
    @RequestMapping("deleteEmployee.do")
    public String deleteEmployee(String employeeId,HttpSession session,Model model){
        if(iEmployeeService.deleteEmployee(employeeId)>0){
            Employee employee1 =(Employee) session.getAttribute("employee");
            //日志登记
            String opeAction = "炒掉员工";
            loadLogs(opeAction,employee1);
            //列表刷新动作
            Integer pn = 1;
            List<Employee> employees = iEmployeeService.selectAllEmployees();
            PageInfo page = loadEmployees(pn,employees);
            model.addAttribute("pageInfo", page);
            return "WEB-INF/employee/manager/PersonnelManager/personnel.jsp";
        }
        else{
            return "error.jsp";
        }
    }

}
