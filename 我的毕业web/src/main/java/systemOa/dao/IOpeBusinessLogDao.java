package systemOa.dao;

import systemOa.bean.OpeBusinessLog;

import java.util.List;

public interface IOpeBusinessLogDao {

    int insertNewLog(OpeBusinessLog opeBusinessLog);

    List<OpeBusinessLog> selectAllLog();

    OpeBusinessLog selectLogByPersonId(String opePersonId);

}
