package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.BusinessProgress;

import java.util.Date;
import java.util.List;

public interface IBusinessProgressDao {

    int insertNewProgress(BusinessProgress businessProgress);

    BusinessProgress selectByIdAndLabel(@Param("businessId") String businessId, @Param("progressLabel")int progressLabel);

    int updateProgressStatus(@Param("businessId") String businessId, @Param("progressLabel")int progressLabel,
                             @Param("modifyTime")Date modifyTime,@Param("progressStatus")int progressStatus);

    //更新detail时，是先查询该部分的businessProgress对象，然后将detail进行新增，而不是覆盖，
    // 并且对于更新的内容要有时间标记
    int updateProgressDetail(@Param("businessId")String businessId,@Param("progressLabel")int progressLabel,
                             @Param("modifyTime")Date modifyTime,@Param("progressDetail")String progressDetail);

    List<BusinessProgress> selectAllProgress(String businessId);
}
