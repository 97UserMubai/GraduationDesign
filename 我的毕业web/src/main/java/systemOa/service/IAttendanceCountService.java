package systemOa.service;

import systemOa.bean.AttendanceCount;

public interface IAttendanceCountService {

    public AttendanceCount selectExitAttendanceCount(String monthId, String employeeId);

    public int insertNewAttendanceCount(AttendanceCount attendanceCount);

    int updateAttendanceCountClock(String monthId,String employeeId,int clockInSuccessCount);

    int updateAttendanceCountKnock(String monthId,String employeeId, int knockOffSuccessCount);

    int updateAttendanceCountClockFail(String monthId,String employeeId, int clockInFailCount);

    int updateAttendanceCountKnockFail(String monthId, String employeeId, int knockOffFailCount);
}
