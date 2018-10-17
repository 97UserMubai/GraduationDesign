package systemOa.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import systemOa.bean.Employee;
import systemOa.bean.OperationLog;
import systemOa.service.IEmployeeService;
import systemOa.service.IOperationLogService;
import systemOa.useClass.FrequentMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
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
        employee = iEmployeeService.LoginCheck(employee.getId(),employee.getPassword());

        if(employee!=null){
            String opeAction = "登录";
//            System.out.println("###########测试");
            loadLogs(opeAction,employee);
            //服务端信息记录
            session.setAttribute("employee",employee);
            return "employeeHeader.jsp";
        }else{
            model.addAttribute("msg", "用户名或密码错误，请重新登录！");
            return "index.jsp";
        }

    }



    //查询所有员工信息
    @RequestMapping("selectAllEmployees.do")
    public String selectAllEmployees(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        List<Employee> employees = iEmployeeService.selectAllEmployees();
        PageInfo page = loadEmployees(pn,employees);
        model.addAttribute("pageInfo", page);
        return "personnel.jsp";
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
            return "personnel.jsp";
        }else{
            return "error.jsp";
        }

    }

    //删除员工
    @RequestMapping("deleteEmployee.do")
    public String deleteEmployee(String id,HttpSession session,Model model){
        if(iEmployeeService.deleteEmployee(id)>0){
            Employee employee1 =(Employee) session.getAttribute("employee");
            //日志登记
            String opeAction = "炒掉员工";
            loadLogs(opeAction,employee1);
            //列表刷新动作
            Integer pn = 1;
            List<Employee> employees = iEmployeeService.selectAllEmployees();
            PageInfo page = loadEmployees(pn,employees);
            model.addAttribute("pageInfo", page);
            return "personnel.jsp";
        }
        else{
            return "error.jsp";
        }
    }

}
