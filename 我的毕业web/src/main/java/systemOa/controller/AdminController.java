package systemOa.controller;

import systemOa.bean.Admin;
import systemOa.bean.OperationLog;
import systemOa.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import systemOa.service.IOperationLogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @ProjectName AirlineSell
 * @ClassName null.java
 * @Author cza
 * @Time 2018/8/3 0003 16:48
 * @Version 1.0
 * @mark null
 * @Description
 */
@Controller
public class AdminController {
    @Autowired
    @Qualifier("adminService")
    private IAdminService service;

    public IAdminService getService() {
        return service;
    }

    public void setService(IAdminService service) {
        this.service = service;
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

    //检查管理员账号登陆
    @RequestMapping("/checkLogin.do")
    public String checkLogin(Admin admin, Model model, HttpSession session){
        //调用service方法
        admin = service.checkLogin(admin.getAccount(), admin.getPassword());

        if(admin != null){

            //进行登录日志登记
            Date opeTime = new Date();
            String opeAction = "登录";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = formatter.format(opeTime);
            String opeAll = admin.getDepartment()+"的"+admin.getName()+"在"+dateString+"进行了"
                    +opeAction+"操作";
            OperationLog operationLog = new OperationLog(admin.getName(),opeTime,opeAction,opeAll);
            iOperationLogService.insertLog(operationLog);
            //服务端记录登录信息
            session.setAttribute("admin",admin);
            model.addAttribute("admin", admin);
//            System.out.println("测试#########"+admin.getAuthority());
            return "WEB-INF/admin/adminHeader.jsp";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "adminLogin.jsp";
    }
    @RequestMapping("/jumpAdMain.do")
    public String jumpAdMain() {
        return "WEB-INF/admin/adminHeader.jsp";
    }
    //注销方法
//    @RequestMapping("/adminOutLogin.do")
//    public String outLogin(HttpSession session){
//        //通过session.invalidata()方法来注销当前的session
//        session.invalidate();
//        return "redirect:adminLogin.do";
//    }


}
