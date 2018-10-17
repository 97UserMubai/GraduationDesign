package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.OperationLog;
import systemOa.dao.IOperationDao;
import systemOa.service.IOperationLogService;

import java.util.Date;
import java.util.List;

@Service("operationLogService")
public class OperationLogImpl implements IOperationLogService {


    @Autowired
    @Qualifier("IOperationDao")
    private IOperationDao iOperationDao;

    public IOperationDao getiOperationDao() {
        return iOperationDao;
    }

    public void setiOperationDao(IOperationDao iOperationDao) {
        this.iOperationDao = iOperationDao;
    }

    @Override
    public int insertLog(OperationLog operationLog) {
//        System.out.println(opePerson);
        int i = iOperationDao.insertLog(operationLog);

        return i;
    }

    @Override
    public List<OperationLog> selectAllLogs() {
        return iOperationDao.selectAllLogs();
    }


}
