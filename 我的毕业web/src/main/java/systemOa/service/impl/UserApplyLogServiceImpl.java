package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.UserApplyLog;
import systemOa.dao.IUserApplyLogDao;
import systemOa.service.IUserApplyLogService;

import java.util.Date;

@Service("userApplyLogService")
public class UserApplyLogServiceImpl implements IUserApplyLogService {

    @Autowired
    @Qualifier("IUserApplyLogDao")
    private IUserApplyLogDao iUserApplyLogDao;

    public IUserApplyLogDao getiUserApplyLogDao() {
        return iUserApplyLogDao;
    }

    public void setiUserApplyLogDao(IUserApplyLogDao iUserApplyLogDao) {
        this.iUserApplyLogDao = iUserApplyLogDao;
    }

    @Override
    public int insertNewApplyLog(UserApplyLog userApplyLog) {
        return iUserApplyLogDao.insertNewApplyLog(userApplyLog);
    }

    @Override
    public int updateProgressLabelById(int progressLabel, String userId) {
        return iUserApplyLogDao.updateProgressLabelById(progressLabel,userId);
    }

    @Override
    public int updateOverTimeById(Date businessOverTime, String userId) {
        return iUserApplyLogDao.updateOverTimeById(businessOverTime,userId);
    }
}
