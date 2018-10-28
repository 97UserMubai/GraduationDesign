package systemOa.service;

import systemOa.bean.FileBean;

import java.util.List;

public interface IFileBeanService {
    public int insertFileLog(FileBean fileBean);

    public List<FileBean> selectAllFileLog();
}
