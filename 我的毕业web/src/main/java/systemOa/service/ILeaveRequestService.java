package systemOa.service;

import org.springframework.stereotype.Service;
import systemOa.bean.LeaveRequest;

import java.util.Date;
import java.util.List;

public interface ILeaveRequestService {

    public int insertNewLeaveRequest(LeaveRequest leaveRequest);

    public List<LeaveRequest> selectAllMessage();

    public LeaveRequest  selectByApplyTimeAndEmployeeId(String employeeId, int status);

}
