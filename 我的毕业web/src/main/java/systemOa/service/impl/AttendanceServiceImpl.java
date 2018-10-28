package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.Attendance;
import systemOa.dao.IAttendanceDao;
import systemOa.service.IAttendanceService;

import java.util.Date;
import java.util.List;

@Service("attendanceService")
public class AttendanceServiceImpl implements IAttendanceService {

    @Autowired
    @Qualifier("IAttendanceDao")
    private IAttendanceDao iAttendanceDao;

    public IAttendanceDao getiAttendanceDao() {
        return iAttendanceDao;
    }

    public void setiAttendanceDao(IAttendanceDao iAttendanceDao) {
        this.iAttendanceDao = iAttendanceDao;
    }

    @Override
    public Attendance selectExistStatus(String monthId, int monthDay,String employeeId) {
        return iAttendanceDao.selectExistStatus(monthId,monthDay,employeeId);
    }

    @Override
    public int insertNewAttendance(Attendance attendance) {
        return iAttendanceDao.insertNewAttendance(attendance);
    }

    @Override
    public Attendance selectAttendanceClockStatus(String monthId, int monthDay, String employeeId) {
        return iAttendanceDao.selectAttendanceClockStatus(monthId,monthDay,employeeId);
    }

    @Override
    public int updateAttendanceClock(Date clockInTime, int clockInStatus, String monthId, int monthDay, String employeeId) {
        return iAttendanceDao.updateAttendanceClock(clockInTime,clockInStatus,monthId,monthDay,employeeId);
    }

    @Override
    public int updateAttendanceKnock(Date knockOffTime, int knockOffStatus, String monthId, int monthDay, String employeeId) {
        return iAttendanceDao.updateAttendanceKnock(knockOffTime,knockOffStatus,monthId,monthDay,employeeId);
    }

    @Override
    public List<Attendance> selectMonthClockAndKnockByEmployeeId(String monthId, String employeeId) {
        return iAttendanceDao.selectMonthClockAndKnockByEmployeeId(monthId,employeeId);
    }

}
