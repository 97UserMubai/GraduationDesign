package systemOa.dao;

import systemOa.bean.FileBean;

import java.util.List;

public interface IFileBeanDao {

    int insertFileLog(FileBean fileBean);

    List<FileBean> selectAllFileLog();

}
