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
import systemOa.bean.LeaveRequest;
import systemOa.bean.Message;
import systemOa.bean.MessageCount;
import systemOa.service.ILeaveRequestService;
import systemOa.service.IMessageCountService;
import systemOa.service.IMessageService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LeaveRequestController {

    @Autowired
    @Qualifier("leaveRequestService")
    private ILeaveRequestService iLeaveRequestService;

    public ILeaveRequestService getiLeaveRequestService() {
        return iLeaveRequestService;
    }

    public void setiLeaveRequestService(ILeaveRequestService iLeaveRequestService) {
        this.iLeaveRequestService = iLeaveRequestService;
    }

    @Autowired
    @Qualifier("messageService")
    private IMessageService iMessageService;

    public IMessageService getiMessageService() {
        return iMessageService;
    }

    public void setiMessageService(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
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

    public int[] isRunYear(int year){
        if((year%4==0 && year%100!=0) || year%400==0){
           int[] MonthDays={31,29,31,30,31,30,31,31,30,31,30,31};
           return MonthDays;
        }
        else {
           int[] MonthDays={31,28,31,30,31,30,31,31,30,31,30,31};
           return MonthDays;
        }
    }

    @RequestMapping("jumpLeaveRequestJsp.do")
    public String jumpLeaveRequestJsp(){
        return "WEB-INF/employee/PublicJsp/MessageManager/leaveRequest.jsp";
    }

    /**
     * 方法用来插入leaveRequest表
     * 同时，对leaveTime和backTime进行判断，然后更新messageCount表和message表
     * 请假跨越时间大于三天则grade=重要，小于三天则普通
     * status等于0为处理中，等于1为已通过，等于2为未通过
     * 部门经理根据grade对message进行审批通过，或者传递到admin
     */
    /**
     * @Param status : 0 待审批 1 审批中 2已通过 3被驳回
    */
    @RequestMapping("insertNewLeaveRequest.do")
    public String insertNewLeaveRequest(LeaveRequest leaveRequest, HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        String style= "请假";
        leaveRequest.setStyle(style);
        leaveRequest.setEmployeeId(employee.getEmployeeId());
        leaveRequest.setPersonName(employee.getName());
        leaveRequest.setDepartment(employee.getDepartment());
        leaveRequest.setStatus(0);
        //创建messageId
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        Date applyTime = new Date();
        String messageId = sdf.format(applyTime);
        leaveRequest.setMessageId(messageId);
        leaveRequest.setApplyTime(applyTime);
        String applyDays = null;
        //对请假时间进行判断
        String leaveTime = leaveRequest.getLeaveTime();
        //使用正则表达式对时间字符串进行分割，然后比较
        String[] strs = leaveTime.split("-");
        String backTime = leaveRequest.getBackTime();
        String[] strs1 = backTime.split("-");
        System.out.println(strs.length);
        System.out.println(strs[0]);
        System.out.println(strs[1]);
        System.out.println(strs[2]);
        int year1 = Integer.parseInt(strs[0]);
        int year2 = Integer.parseInt(strs1[0]);
        int month1 = Integer.parseInt(strs[1]);
        int month2 = Integer.parseInt(strs1[1]);
        int a = Integer.parseInt(strs[2]);
        int b = Integer.parseInt(strs1[2]);
        //对年月份进行比较
        int c = 0;
        if(year1 == year2){
            int[] monthDays = isRunYear(year1);
            if(month1==month2){
                c = b-a+1;
                applyDays = String.valueOf(c)+"天";
            }
            if(month1!=month2){
                if(month2-month1==1){
                    c = monthDays[month1-1]+b-a;
                    applyDays = String.valueOf(c)+"天";
                }
                //如果跨越月份，则区分跨了几个月，并计算对应的时间天数
                if(month2-month1>1){
                    int i = month2-month1;
                    do{
                        c = c+monthDays[month1+i-1];
                    }while(i-1<=1);
                    c = c +monthDays[month1-1]+b-a;
                    applyDays = String.valueOf(c)+"天";
                }
            }
        }
        if(year1!=year2){
            if(year2-year1>1){
                leaveRequest.setApplyDays("一年以上");
            }
            else{
                int[] monthDays1 = isRunYear(year1);
                int[] monthDays2 = isRunYear(year2);
                int c1 = 0;
                int c2 = 0;
                if(12-month1>0){
                    for(int j = month1+1;j<=12;j++){
                        c1 =c1+ monthDays1[j-1];
                    }
                    c1 = c1 + monthDays1[month1-1]-a;
                }
                else {
                    c1 = monthDays1[month1-1]-a;
                }
                if(month2-1>0){
                    for(int j = 1;j<=month2-1;j++){
                        c2 = c2+monthDays2[j-1];
                    }
                    c2 = c2 + b;
                }
                else{
                    c2 = b;
                }
                c = c1 +c2;
                applyDays = String.valueOf(c)+"天";
            }
        }//跨年请假天数判定结束
        leaveRequest.setApplyDays(applyDays);
        //对请假的等级进行判断
        //①请假天数②请假人的身份
        String grade = null;
        if(employee.getIdentity().equals("部门经理")){
            grade = "重要";
        }
        else if(employee.getIdentity().equals("普通员工")||employee.getIdentity().equals("实习生")){
            if(c>=3){
                grade = "重要";
            }
            else{
                grade = "普通";
            }

        }
        //执行请假表插入操作
        int i = iLeaveRequestService.insertNewLeaveRequest(leaveRequest);
        if(i>0){
//            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-DD hh:mm:ss");
//            String str = sdf1.format(applyTime);
//            int id = iLeaveRequestService.selecteCeshiMessageId(employee.getEmployeeId(),str);
//            System.out.println(id);
            Message message = new Message(messageId,style,0,grade,applyTime,
                    null,null,null);
            //执行Message表的插入
            iMessageService.insertNewMessage(message);
            MessageCount messageCount = (MessageCount)iMessageCountService.selectAllMessage();
            //对messageCount表进行更新
            if(grade.equals("普通")){
                iMessageCountService.updateNormalMessageCount(messageCount.getNormalMessageCount()+1);
            }
            if(grade.equals("重要")){
                iMessageCountService.updateImportantMessageCount(messageCount.getImportantMessageCount()+1);
            }
            session.setAttribute("message","登记成功");
           return "error.jsp";
        }
        session.setAttribute("message","登记失败");
        return "error.jsp";
    }

    //对查询结果进行分页处理，获取对应authority，根据权限查询对应的历史信息范围
    @RequestMapping("selectHistoryMessage.do")
    public String selectHistoryMessage(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model, HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        int pageSize = 1000;
        //pageSize为总的记录长度
        PageHelper.startPage(pn, pageSize);
        if(employee.getAuthority()==2){
            List<LeaveRequest> leaveRequests = iLeaveRequestService.selectAllMessage(employee.getDepartment());
            PageInfo page = new PageInfo(leaveRequests, pageSize);
            model.addAttribute("pageInfo", page);
            return "messageManager.jsp";
        }
        if(employee.getAuthority()==3||employee.getAuthority()==4){
            List<LeaveRequest> leaveRequests = iLeaveRequestService.selectAllMessageByEmployeeId(employee.getEmployeeId());
            PageInfo page = new PageInfo(leaveRequests, pageSize);
            model.addAttribute("pageInfo", page);
            return "messageManager.jsp";
        }
        session.setAttribute("message","不知道为啥为跳转到这里");
        return "error.jsp";
    }

    //查询指定位置的message，通过MessageId
    @RequestMapping("getMessage")
    public void selectMessageByMessageId(String messageId,HttpSession session){
        int i = 0;
        LeaveRequest leaveRequest = iLeaveRequestService.selectMessageByMessageId(messageId);
        i = 1;
        System.out.println(i);
        session.setAttribute("leaveRequest1",leaveRequest);
    }



}
