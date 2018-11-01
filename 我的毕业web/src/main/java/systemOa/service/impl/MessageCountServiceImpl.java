package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.MessageCount;
import systemOa.dao.IMessageCountDao;
import systemOa.service.IMessageCountService;

@Service("messageCountService")
public class MessageCountServiceImpl implements IMessageCountService {

    @Autowired
    @Qualifier("IMessageCountDao")
    private IMessageCountDao iMessageCountDao;

    public IMessageCountDao getiMessageCountDao() {
        return iMessageCountDao;
    }

    public void setiMessageCountDao(IMessageCountDao iMessageCountDao) {
        this.iMessageCountDao = iMessageCountDao;
    }

    @Override
    public int SelectNormalMessageCount() {
        return iMessageCountDao.selectNormalMessageCount();
    }

    @Override
    public int SelectImportantMessageCount() {
        return iMessageCountDao.selectImportantMessageCount();
    }

    @Override
    public int updateNormalMessageCount(int normalMessageCount) {
        return iMessageCountDao.updateNormalMessageCount(normalMessageCount);
    }

    @Override
    public int updateImportantMessageCount(int importantMessageCount) {
        return iMessageCountDao.updateImportantMessageCount(importantMessageCount);
    }

    @Override
    public MessageCount selectAllMessage() {
        return iMessageCountDao.selectAllMessage();
    }
}
