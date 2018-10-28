package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.Attendance;

import java.util.Date;
import java.util.List;

public interface IAttendanceDao {

        Attendance selectExistStatus(@Param("monthId") String monthId, @Param("monthDay") int monthDay,
                                     @Param("employeeId") String employeeId);

        int insertNewAttendance(Attendance attendance);

        Attendance selectAttendanceClockStatus(@Param("monthId") String monthId, @Param("monthDay") int monthDay,
                                        @Param("employeeId") String employeeId);

        int updateAttendanceClock(@Param("clockInTime")Date clockInTime,@Param("clockInStatus") int clockInStatus,
                                  @Param("monthId")String monthId,@Param("monthDay")int monthDay,
                                  @Param("employeeId")String employeeId);

        int updateAttendanceKnock(@Param("knockOffTime")Date knockOffTime,@Param("knockOffStatus")int knockOffStatus,
                                  @Param("monthId")String monthId,@Param("monthDay")int monthDay,
                                  @Param("employeeId")String employeeId);

        List<Attendance> selectMonthClockAndKnockByEmployeeId(@Param("monthId")String monthId,
                                                              @Param("employeeId")String employeeId);



}
