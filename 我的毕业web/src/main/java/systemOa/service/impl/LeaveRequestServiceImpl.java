package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.LeaveRequest;
import systemOa.dao.ILeaveRequestDao;
import systemOa.service.ILeaveRequestService;

import java.util.Date;
import java.util.List;

@Service("leaveRequestService")
public class LeaveRequestServiceImpl implements ILeaveRequestService {

    @Autowired
    @Qualifier("ILeaveRequestDao")
    private ILeaveRequestDao iLeaveRequestDao;

    public ILeaveRequestDao getiLeaveRequestDao() {
        return iLeaveRequestDao;
    }

    public void setiLeaveRequestDao(ILeaveRequestDao iLeaveRequestDao) {
        this.iLeaveRequestDao = iLeaveRequestDao;
    }

    @Override
    public int insertNewLeaveRequest(LeaveRequest leaveRequest) {
        return iLeaveRequestDao.insertNewLeaveRequest(leaveRequest);
    }

    @Override
    public List<LeaveRequest> selectAllMessageByEmployeeId(String employeeId) {
        return iLeaveRequestDao.selectAllMessageByEmployeeId(employeeId);
    }

    @Override
    public List<LeaveRequest> selectAllMessage(String department) {
        return iLeaveRequestDao.selectAllMessage(department);
    }

    @Override
    public LeaveRequest selectByApplyTimeAndEmployeeId(String employeeId, int status) {
        return iLeaveRequestDao.selectByApplyTimeAndEmployeeId(employeeId,status);
    }

    @Override
    public int selecteCeshiMessageId(String employeeId, String applyTime) {
        return iLeaveRequestDao.selecteCeshiMessageId(employeeId,applyTime);
    }

    @Override
    public LeaveRequest selectMessageByMessageId(String messageId) {
        return iLeaveRequestDao.selectMessageByMessageId(messageId);
    }


}
