package systemOa.useClass;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import systemOa.bean.Employee;
import systemOa.bean.OperationLog;
import systemOa.service.IEmployeeService;
import systemOa.service.IOperationLogService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FrequentMethod {

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
//        String opeAll = "人事部的村口二蛋在"+dateString+"进行了登录操作";
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
}
