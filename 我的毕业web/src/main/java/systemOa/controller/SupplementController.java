package systemOa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import systemOa.bean.Employee;
import systemOa.bean.Supplement;
import systemOa.service.ISupplementService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SupplementController {

    @Autowired
    @Qualifier("supplementSerive")
    private ISupplementService iSupplementService;

    public ISupplementService getiSupplementService() {
        return iSupplementService;
    }

    public void setiSupplementService(ISupplementService iSupplementService) {
        this.iSupplementService = iSupplementService;
    }

    @RequestMapping("applySupplement.do")
    public String applySupplement(Supplement supplement, HttpSession session){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        Date applyTime = new Date();
        String messageId = sdf.format(applyTime);
        supplement.setMessageId(messageId);
        //获取主键id:messageId
        String style = "补签";
        supplement.setStyle(style);
        //获取message style
        Employee employee = (Employee)session.getAttribute("employee");
        supplement.setEmployeeId(employee.getEmployeeId());
        supplement.setPersonName(employee.getName());
        supplement.setDepartment(employee.getDepartment());
        //获取message 的 员工id姓名和部门信息
        if(supplement.getSupplementTime().equals("1")){
            supplement.setSupplementTime("上午:6:00-8:30");
        }
        if(supplement.getSupplementTime().equals("2")){
            supplement.setSupplementTime("下午:17:30-22:00");
        }
        //获取缺签时间段的信息
        supplement.setStatus(0);
        //设置信息状态为0：未审批
        supplement.setApplyTime(applyTime);
        int i = iSupplementService.insertNewSupplement(supplement);
        if(i>0){
            session.setAttribute("message","提交申请成功");
            return "error.jsp";
        }
        session.setAttribute("message","我也不知道为什么会跳转到这个位置");
        return "error.jsp";
    }

}
