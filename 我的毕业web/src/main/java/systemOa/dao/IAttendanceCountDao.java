package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.AttendanceCount;

public interface IAttendanceCountDao {

    AttendanceCount selectExitAttendanceCount(@Param("monthId") String monthId, @Param("employeeId") String employeeId);

    int insertNewAttendanceCount(AttendanceCount attendanceCount);

    int updateAttendanceCountClock(@Param("monthId") String monthId, @Param("employeeId") String employeeId,
                                   @Param("clockInSuccessCount")int clockInSuccessCount);

    int updateAttendanceCountKnock(@Param("monthId") String monthId, @Param("employeeId") String employeeId,
                                   @Param("knockOffSuccessCount")int knockOffSuccessCount);

    int updateAttendanceCountClockFail(@Param("monthId") String monthId, @Param("employeeId") String employeeId,
                                   @Param("clockInFailCount")int clockInFailCount);

    int updateAttendanceCountKnockFail(@Param("monthId") String monthId, @Param("employeeId") String employeeId,
                                   @Param("knockOffFailCount")int knockOffFailCount);
}
