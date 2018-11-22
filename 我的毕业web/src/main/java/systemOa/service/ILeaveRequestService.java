package systemOa.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import systemOa.bean.LeaveRequest;

import java.util.Date;
import java.util.List;

public interface ILeaveRequestService {

    public int insertNewLeaveRequest(LeaveRequest leaveRequest);

    public List<LeaveRequest> selectAllMessageByEmployeeId(String employeeId);

    public List<LeaveRequest> selectAllMessage(String department);

    public LeaveRequest  selectByApplyTimeAndEmployeeId(String employeeId, int status);

    public int selecteCeshiMessageId(String employeeId,String applyTime);

    public LeaveRequest  selectMessageByMessageId(String messageId);


}
