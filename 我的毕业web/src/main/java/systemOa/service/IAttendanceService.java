package systemOa.service;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.Attendance;

import java.util.Date;
import java.util.List;

public interface IAttendanceService {

    //员工登录时测试当天是否已经存在一个记录签到签退的字段查询
    public Attendance selectExistStatus(String monthId, int monthDay,String employeeId);

    public int insertNewAttendance(Attendance attendance);

    public Attendance selectAttendanceClockStatus(String monthId,int monthDay,String employeeId);

    public int updateAttendanceClock( Date clockInTime,int clockInStatus, String monthId,
                               int monthDay, String employeeId);

    public int updateAttendanceKnock(Date knockOffTime,int knockOffStatus, String monthId,
                              int monthDay, String employeeId);

    public List<Attendance> selectMonthClockAndKnockByEmployeeId(String monthId, String employeeId);

    public List<Attendance> selectMonthClockAndKnockByMonthID(String monthId);
}
