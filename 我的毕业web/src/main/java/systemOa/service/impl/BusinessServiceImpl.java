package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.Business;
import systemOa.dao.IBusinessDao;
import systemOa.service.IBusinessService;

@Service("businessService")
public class BusinessServiceImpl implements IBusinessService {

    @Autowired
    @Qualifier("IBusinessDao")
    private IBusinessDao iBusinessDao;

    public IBusinessDao getiBusinessDao() {
        return iBusinessDao;
    }

    public void setiBusinessDao(IBusinessDao iBusinessDao) {
        this.iBusinessDao = iBusinessDao;
    }

    @Override
    public int insertNewBusiness(Business business) {
        return iBusinessDao.insertNewBusiness(business);
    }
}
