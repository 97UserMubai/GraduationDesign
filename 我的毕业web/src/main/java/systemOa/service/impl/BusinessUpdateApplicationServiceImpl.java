package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.BusinessUpdateApplication;
import systemOa.dao.IBusinessUpdateApplicationDao;
import systemOa.service.IBusinessUpdateApplicationService;

import java.util.Date;

@Service("businessUpdateApplicationService")
public class BusinessUpdateApplicationServiceImpl implements IBusinessUpdateApplicationService {

    @Autowired
    @Qualifier("IBusinessUpdateApplicationDao")
    private IBusinessUpdateApplicationDao iBusinessUpdateApplicationDao;

    public IBusinessUpdateApplicationDao getiBusinessUpdateApplicationDao() {
        return iBusinessUpdateApplicationDao;
    }

    public void setiBusinessUpdateApplicationDao(IBusinessUpdateApplicationDao iBusinessUpdateApplicationDao) {
        this.iBusinessUpdateApplicationDao = iBusinessUpdateApplicationDao;
    }

    //插入
    @Override
    public int insertNewApplication(BusinessUpdateApplication businessUpdateApplication) {
        return iBusinessUpdateApplicationDao.insertNewApplication(businessUpdateApplication);
    }

    //更新
    @Override
    public int updateApplication(String messageId, int status, String provePerson, String proveReason, Date proveTime) {
        return iBusinessUpdateApplicationDao.updateApplication(messageId,status,provePerson,proveReason,proveTime);
    }

    //查询
    @Override
    public BusinessUpdateApplication selectApplicationById(String messageId) {
        return iBusinessUpdateApplicationDao.selectApplicationById(messageId);
    }


}
