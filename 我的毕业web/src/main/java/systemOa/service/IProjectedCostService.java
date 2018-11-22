package systemOa.service;

import org.apache.ibatis.annotations.Param;
import systemOa.bean.ProjectedCost;

public interface IProjectedCostService {

    int insertNewPC(ProjectedCost projectedCost);

    int updatePc(ProjectedCost projectedCost, String businessId);

}
