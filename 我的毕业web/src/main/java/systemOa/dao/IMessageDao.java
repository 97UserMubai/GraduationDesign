package systemOa.dao;

import systemOa.bean.Message;

import java.util.List;

public interface IMessageDao {

    int insertNewMessage(Message message);

    List<Message> selectAllMessage();

}
