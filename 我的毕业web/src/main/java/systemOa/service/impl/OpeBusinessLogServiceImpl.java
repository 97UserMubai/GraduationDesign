package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.OpeBusinessLog;
import systemOa.dao.IOpeBusinessLogDao;
import systemOa.service.IOpeBusinessLogService;

import java.util.List;

@Service("opeBusinessLogService")
public class OpeBusinessLogServiceImpl implements IOpeBusinessLogService {

    @Autowired
    @Qualifier("IOpeBusinessLogDao")
    private IOpeBusinessLogDao iOpeBusinessLogDao;

    public IOpeBusinessLogDao getiOpeBusinessLogDao() {
        return iOpeBusinessLogDao;
    }

    public void setiOpeBusinessLogDao(IOpeBusinessLogDao iOpeBusinessLogDao) {
        this.iOpeBusinessLogDao = iOpeBusinessLogDao;
    }

    @Override
    public int insertNewLog(OpeBusinessLog opeBusinessLog) {
        return iOpeBusinessLogDao.insertNewLog(opeBusinessLog);
    }

    @Override
    public List<OpeBusinessLog> selectAllLog() {
        return iOpeBusinessLogDao.selectAllLog();
    }

    @Override
    public OpeBusinessLog selectLogByPersonId(String opePersonId) {
        return iOpeBusinessLogDao.selectLogByPersonId(opePersonId);
    }
}
