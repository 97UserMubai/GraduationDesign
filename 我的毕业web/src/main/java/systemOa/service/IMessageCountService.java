package systemOa.service;

import systemOa.bean.MessageCount;

public interface IMessageCountService {
    public int SelectNormalMessageCount();

    public int SelectImportantMessageCount();

    public int updateNormalMessageCount(int normalMessageCount);

    public int updateImportantMessageCount(int importantMessageCount);

    public MessageCount selectAllMessage();
}
