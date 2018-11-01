package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.Message;
import systemOa.dao.IMessageDao;
import systemOa.service.IMessageService;

import java.util.List;

@Service("messageService")
public class MessageServiceImpl implements IMessageService {

    @Autowired
    @Qualifier("IMessageDao")
    private IMessageDao iMessageDao;

    public IMessageDao getiMessageDao() {
        return iMessageDao;
    }

    public void setiMessageDao(IMessageDao iMessageDao) {
        this.iMessageDao = iMessageDao;
    }

    @Override
    public int insertNewMessage(Message message) {
        return iMessageDao.insertNewMessage(message);
    }

    @Override
    public List<Message> selectAllMessage() {
        return iMessageDao.selectAllMessage();
    }
}
