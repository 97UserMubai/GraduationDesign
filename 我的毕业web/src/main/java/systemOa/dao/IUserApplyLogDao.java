package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.UserApplyLog;

import java.util.Date;

public interface IUserApplyLogDao {
    //当客户发出申请时，就生成该部分表的记录，需要提供检测功能，如果有为over的申请，则不能继续申请
    int insertNewApplyLog(UserApplyLog userApplyLog);

    int updateProgressLabelById(@Param("progressLabel")int  progressLabel,@Param("userId") String userId);

    int updateOverTimeById(@Param("businessOverTime") Date businessOverTime, @Param("userId") String userId);
}
