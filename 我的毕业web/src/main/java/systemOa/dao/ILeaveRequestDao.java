package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.LeaveRequest;

import java.util.Date;
import java.util.List;

public interface ILeaveRequestDao {

    int insertNewLeaveRequest(LeaveRequest leaveRequest);

    List<LeaveRequest> selectAllMessage();

    LeaveRequest  selectByApplyTimeAndEmployeeId(@Param("employeeId") String employeeId,
                                        @Param("status") int status);

}
