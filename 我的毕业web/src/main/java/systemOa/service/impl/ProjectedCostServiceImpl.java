package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.ProjectedCost;
import systemOa.dao.IProjectedCostDao;
import systemOa.service.IProjectedCostService;

@Service("projectedCostService")
public class ProjectedCostServiceImpl implements IProjectedCostService {

    @Autowired
    @Qualifier("IProjectedCostDao")
    private IProjectedCostDao iProjectedCostDao;

    public IProjectedCostDao getiProjectedCostDao() {
        return iProjectedCostDao;
    }

    public void setiProjectedCostDao(IProjectedCostDao iProjectedCostDao) {
        this.iProjectedCostDao = iProjectedCostDao;
    }

    @Override
    public int insertNewPC(ProjectedCost projectedCost) {
        return iProjectedCostDao.insertNewPC(projectedCost);
    }

    //这里存在疑问，以前对表更新都是更新部分属性
    //现在更新的以对象包装住所有属性，不知道能不能传得过去
    @Override
    public int updatePc(ProjectedCost projectedCost, String businessId) {
        return iProjectedCostDao.updatePc(projectedCost,businessId);
    }
}
