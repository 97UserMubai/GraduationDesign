package systemOa.dao;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.ProjectedCost;

public interface IProjectedCostDao {

    int insertNewPC(ProjectedCost projectedCost);

    int updatePc(@Param("projectedCost") ProjectedCost projectedCost,
                 @Param("businessId") String businessId);

}
