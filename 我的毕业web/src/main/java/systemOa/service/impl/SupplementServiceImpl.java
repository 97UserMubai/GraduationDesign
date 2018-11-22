package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.Supplement;
import systemOa.dao.ISupplementDao;
import systemOa.service.ISupplementService;

@Service("supplementSerive")
public class SupplementServiceImpl implements ISupplementService {
    @Autowired
    @Qualifier("ISupplementDao")
    private ISupplementDao iSupplementDao;

    public ISupplementDao getiSupplementDao() {
        return iSupplementDao;
    }

    public void setiSupplementDao(ISupplementDao iSupplementDao) {
        this.iSupplementDao = iSupplementDao;
    }

    @Override
    public int insertNewSupplement(Supplement supplement) {
        return iSupplementDao.insertNewSupplement(supplement);
    }
}
