package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.FileBean;
import systemOa.dao.IFileBeanDao;
import systemOa.service.IFileBeanService;

@Service("fileBeanService")
public class FileBeanService implements IFileBeanService {


    @Autowired
    @Qualifier("IFileBeanDao")
    private IFileBeanDao iFileBeanDao;

    public IFileBeanDao getiFileBeanDao() {
        return iFileBeanDao;
    }

    public void setiFileBeanDao(IFileBeanDao iFileBeanDao) {
        this.iFileBeanDao = iFileBeanDao;
    }

    @Override
    public int insertFileLog(FileBean fileBean) {
        return iFileBeanDao.insertFileLog(fileBean);
    }
}
