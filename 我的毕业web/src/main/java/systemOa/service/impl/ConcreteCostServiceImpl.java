package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.ConcreteCost;
import systemOa.dao.IConcreteCostDao;
import systemOa.service.IConcreteCostService;

@Service("concreteCostService")
public class ConcreteCostServiceImpl implements IConcreteCostService {

    @Autowired
    @Qualifier("IConcreteCostDao")
    private IConcreteCostDao iConcreteCostDao;

    public IConcreteCostDao getiConcreteCostDao() {
        return iConcreteCostDao;
    }

    public void setiConcreteCostDao(IConcreteCostDao iConcreteCostDao) {
        this.iConcreteCostDao = iConcreteCostDao;
    }

    @Override
    public int insertNewCC(ConcreteCost concreteCost) {
        return iConcreteCostDao.insertNewCC(concreteCost);
    }

    @Override
    public int updateCC(ConcreteCost concreteCost, String businessId) {
        return iConcreteCostDao.updateCC(concreteCost,businessId);
    }


}
