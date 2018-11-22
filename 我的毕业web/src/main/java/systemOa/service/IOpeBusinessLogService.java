package systemOa.service;

import systemOa.bean.OpeBusinessLog;

import java.util.List;

public interface IOpeBusinessLogService {
    int insertNewLog(OpeBusinessLog opeBusinessLog);

    List<OpeBusinessLog> selectAllLog();

    OpeBusinessLog selectLogByPersonId(String opePersonId);
}
