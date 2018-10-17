package systemOa.dao;

import systemOa.bean.OperationLog;

import java.util.Date;
import java.util.List;

public interface IOperationDao {
    int insertLog(OperationLog operationLog);

    List<OperationLog> selectAllLogs();
}
