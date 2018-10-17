package systemOa.service;

import systemOa.bean.OperationLog;


import java.util.List;

public interface IOperationLogService {

    public int insertLog(OperationLog operationLog);

    public List<OperationLog> selectAllLogs();
}
