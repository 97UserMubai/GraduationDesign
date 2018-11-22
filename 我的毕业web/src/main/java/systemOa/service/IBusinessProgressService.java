package systemOa.service;


import systemOa.bean.BusinessProgress;

import java.util.Date;
import java.util.List;

public interface IBusinessProgressService {
    int insertNewProgress(BusinessProgress businessProgress);

    BusinessProgress selectByIdAndLabel(String businessId,int progressLabel);

    int updateProgressStatus( String businessId,int progressLabel, Date modifyTime, int progressStatus);

    //更新detail时，是先查询该部分的businessProgress对象，然后将detail进行新增，而不是覆盖，
    // 并且对于更新的内容要有时间标记
    int updateProgressDetail(String businessId,int progressLabel, Date modifyTime,String progressDetail);

    List<BusinessProgress> selectAllProgress(String businessId);
}
