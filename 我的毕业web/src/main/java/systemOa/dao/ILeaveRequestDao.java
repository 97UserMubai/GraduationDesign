package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.LeaveRequest;

import java.util.Date;
import java.util.List;

public interface ILeaveRequestDao {

    int insertNewLeaveRequest(LeaveRequest leaveRequest);

    List<LeaveRequest> selectAllMessageByEmployeeId(String employeeId);

    List<LeaveRequest> selectAllMessage(String department);

    LeaveRequest  selectByApplyTimeAndEmployeeId(@Param("employeeId") String employeeId,
                                        @Param("status") int status);

    LeaveRequest  selectMessageByMessageId(@Param("messageId") String messageId);

    int selecteCeshiMessageId(@Param("employeeId")String employeeId,@Param("applyTime")String applyTime);
}
