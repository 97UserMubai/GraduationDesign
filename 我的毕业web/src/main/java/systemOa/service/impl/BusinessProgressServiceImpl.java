package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.BusinessProgress;
import systemOa.dao.IBusinessProgressDao;
import systemOa.service.IBusinessProgressService;

import java.util.Date;
import java.util.List;

@Service("businessProgressService")
public class BusinessProgressServiceImpl implements IBusinessProgressService {

    @Autowired
    @Qualifier("IBusinessProgressDao")
    private IBusinessProgressDao iBusinessProgressDao;

    public IBusinessProgressDao getiBusinessProgressDao() {
        return iBusinessProgressDao;
    }

    public void setiBusinessProgressDao(IBusinessProgressDao iBusinessProgressDao) {
        this.iBusinessProgressDao = iBusinessProgressDao;
    }

    @Override
    public int insertNewProgress(BusinessProgress businessProgress) {
        return iBusinessProgressDao.insertNewProgress(businessProgress);
    }

    @Override
    public BusinessProgress selectByIdAndLabel(String businessId, int progressLabel) {
        return iBusinessProgressDao.selectByIdAndLabel(businessId,progressLabel);
    }

    @Override
    public int updateProgressStatus(String businessId, int progressLabel, Date modifyTime, int progressStatus) {
        return iBusinessProgressDao.updateProgressStatus(businessId,progressLabel,modifyTime,progressStatus);
    }

    @Override
    public int updateProgressDetail(String businessId, int progressLabel, Date modifyTime, String progressDetail) {
        return iBusinessProgressDao.updateProgressDetail(businessId,progressLabel,modifyTime,progressDetail);
    }

    @Override
    public List<BusinessProgress> selectAllProgress(String businessId) {
        return iBusinessProgressDao.selectAllProgress(businessId);
    }
}
