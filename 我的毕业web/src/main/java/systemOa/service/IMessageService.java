package systemOa.service;

import systemOa.bean.Message;

import java.util.List;

public interface IMessageService {
    int insertNewMessage(Message message);

    List<Message> selectAllMessage();
}
