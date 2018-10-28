package systemOa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import systemOa.bean.Attendance;
import systemOa.bean.AttendanceCount;
import systemOa.bean.Employee;
import systemOa.bean.OperationLog;
import systemOa.service.IAttendanceCountService;
import systemOa.service.IAttendanceService;
import systemOa.service.IOperationLogService;
import systemOa.useClass.FrequentMethod;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AttendanceController {


    @Autowired
    @Qualifier("attendanceCountService")
    private IAttendanceCountService iAttendanceCountService;

    public IAttendanceCountService getiAttendanceCountService() {
        return iAttendanceCountService;
    }

    public void setiAttendanceCountService(IAttendanceCountService iAttendanceCountService) {
        this.iAttendanceCountService = iAttendanceCountService;
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
    @Qualifier("operationLogService")
    private IOperationLogService iOperationLogService;

    public IOperationLogService getiOperationLogService() {
        return iOperationLogService;
    }

    public void setiOperationLogService(IOperationLogService iOperationLogService) {
        this.iOperationLogService = iOperationLogService;
    }

    @RequestMapping("jumpAttendanceIndex.do")
    public String jumpAttendanceIndex(){
        return "WEB-INF/employee/PublicJsp/AttendanceManager/AttendanceIndex.jsp";
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

    //页面进入的状态判断，查询该员工的当天签到状态，from月份签到签退表
    @RequestMapping("selectAttendanceClockStatus.do")
    public String selectAttendanceClockStatus(Model model, HttpSession session){
        Attendance attendance = (Attendance)session.getAttribute("attendance");
        Attendance attendance1 = iAttendanceService.selectAttendanceClockStatus(attendance.getMonthId(),
                attendance.getMonthDay(),attendance.getEmployeeId());
        if(attendance1.getClockInStatus()==1){
            String msg = "今天已经签到，请勿重复签到";
            String msg2 = null;
            session.setAttribute("msg",msg);
            session.setAttribute("msg2",msg2);
            return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
        }
        if(attendance1.getClockInStatus()==0){
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            Date date = new Date();
            int a = Integer.parseInt(sdf.format(date).toString());
            if(a>83059){
                String msg = "签到失败！已超过签到时间！";
                String msg2 = null;
                session.setAttribute("msg",msg);
                session.setAttribute("msg2",msg2);
                return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
            }
            else if(a<60000){
                String msg = "签到失败！签到时间6:00-8:30！";
                String msg2 = null;
                session.setAttribute("msg",msg);
                session.setAttribute("msg2",msg2);
                return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
            }
            else{
                AttendanceCount attendanceCount = iAttendanceCountService.selectExitAttendanceCount(attendance.getMonthId(),
                        attendance.getEmployeeId());
                if(attendanceCount==null){
                    AttendanceCount attendanceCount11 = new AttendanceCount(attendance.getMonthId(),
                            attendance.getEmployeeId(),attendance.getPersonName(),attendance.getDepartment(),
                            0,0,0,0);
                    iAttendanceCountService.insertNewAttendanceCount(attendanceCount11);
                }
                if(iAttendanceService.updateAttendanceClock(date,1,
                        attendance.getMonthId(),attendance.getMonthDay(),attendance.getEmployeeId())>0){
                    String msg = "签到成功！";
                    String msg2 = null;
                    session.setAttribute("msg",msg);
                    session.setAttribute("msg2",msg2);
                    Employee employee = (Employee)session.getAttribute("employee");
                    String opeAction = "签到";
                    loadLogs(opeAction,employee);
                    //签到次数统计
                    int count = 0;
                    if(attendanceCount==null){
                        count = 1;
                    }
                    else{
                        count = attendanceCount.getClockInSuccessCount()+1;
                    }
                    iAttendanceCountService.updateAttendanceCountClock(attendance.getMonthId(),
                            attendance.getEmployeeId(),count);
                    return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
                }
                else{
                    return "error.jsp";
                }
            }

        }
        return "error.jsp";
    }

    //签退操作
    @RequestMapping("selectAttendanceKnockStatus.do")
    public String selectAttendanceKnockStatus(Model model, HttpSession session){
        Attendance attendance = (Attendance)session.getAttribute("attendance");
        Attendance attendance1 = iAttendanceService.selectAttendanceClockStatus(attendance.getMonthId(),
                attendance.getMonthDay(),attendance.getEmployeeId());
        if(attendance1.getKnockOffStatus()==1){
            String msg2 = "今天已经签退，请勿重复操作";
            String msg = null;
            session.setAttribute("msg2",msg2);
            session.setAttribute("msg",msg);
            return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
        }
        if(attendance1.getKnockOffStatus()==0){
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            Date date = new Date();
            int a = Integer.parseInt(sdf.format(date).toString());

            if(a<173000){

                String msg2 = "签退失败！还未到下班时间！";
                String msg = null;
                session.setAttribute("msg2",msg2);
                session.setAttribute("msg",msg);
                return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
            }
            else if(a>225959){
                String msg2 = "签退失败！签退时间17:50-22:00，如需加班，请填写加班申请！";
                String msg = null;
                session.setAttribute("msg2",msg2);
                session.setAttribute("msg",msg);
                return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
            }
            else{
                //判断该monthID的月份签到签退统计表是否存在
                AttendanceCount attendanceCount = iAttendanceCountService.selectExitAttendanceCount(attendance.getMonthId(),
                        attendance.getEmployeeId());
                if(attendanceCount==null){
                    AttendanceCount attendanceCount11 = new AttendanceCount(attendance.getMonthId(),
                            attendance.getEmployeeId(),attendance.getPersonName(),attendance.getDepartment(),
                            0,0,0,0);
                    iAttendanceCountService.insertNewAttendanceCount(attendanceCount11);
                }
                if(iAttendanceService.updateAttendanceKnock(date,1,
                        attendance.getMonthId(),attendance.getMonthDay(),attendance.getEmployeeId())>0){
                    String msg2 = "签退成功！";
                    String msg = null;
                    session.setAttribute("msg2",msg2);
                    session.setAttribute("msg",msg);
                    //签到日志登记
                    Employee employee = (Employee)session.getAttribute("employee");
                    String opeAction = "签退";
                    loadLogs(opeAction,employee);
                    //月份签退次数登记
                    int count = 0;
                    if(attendanceCount==null){
                        count = 1;
                    }
                    else{
                        count = attendanceCount.getKnockOffSuccessCount()+1;
                    }
                    iAttendanceCountService.updateAttendanceCountKnock(attendance.getMonthId(),
                            attendance.getEmployeeId(),count);
                    return "WEB-INF/employee/PublicJsp/AttendanceManager/ClockAndKnockSuccessJsp.jsp";
                }
                else{
                    return "error.jsp";
                }
            }

        }
        return "error.jsp";
    }


}
