package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.AttendanceCount;
import systemOa.dao.IAttendanceCountDao;
import systemOa.service.IAttendanceCountService;

@Service("attendanceCountService")
public class AttendanceCountServiceImpl implements IAttendanceCountService {

    @Autowired
    @Qualifier("IAttendanceCountDao")
    private IAttendanceCountDao iAttendanceCountDao;

    public IAttendanceCountDao getiAttendanceCountDao() {
        return iAttendanceCountDao;
    }

    public void setiAttendanceCountDao(IAttendanceCountDao iAttendanceCountDao) {
        this.iAttendanceCountDao = iAttendanceCountDao;
    }

    @Override
    public AttendanceCount selectExitAttendanceCount(String monthId, String employeeId) {
        return iAttendanceCountDao.selectExitAttendanceCount(monthId,employeeId);
    }

    @Override
    public int insertNewAttendanceCount(AttendanceCount attendanceCount) {
        return iAttendanceCountDao.insertNewAttendanceCount(attendanceCount);
    }

    @Override
    public int updateAttendanceCountClock(String monthId, String employeeId, int clockInSuccessCount) {
        return iAttendanceCountDao.updateAttendanceCountClock(monthId,employeeId,clockInSuccessCount);
    }

    @Override
    public int updateAttendanceCountKnock(String monthId, String employeeId, int knockOffSuccessCount) {
        return iAttendanceCountDao.updateAttendanceCountKnock(monthId,employeeId,knockOffSuccessCount);
    }

    @Override
    public int updateAttendanceCountClockFail(String monthId, String employeeId, int clockInFailCount) {
        return iAttendanceCountDao.updateAttendanceCountClockFail(monthId,employeeId,clockInFailCount);
    }

    @Override
    public int updateAttendanceCountKnockFail(String monthId, String employeeId, int knockOffFailCount) {
        return iAttendanceCountDao.updateAttendanceCountKnockFail(monthId,employeeId,knockOffFailCount);
    }
}
