package systemOa.dao;

import systemOa.bean.MessageCount;

public interface IMessageCountDao {

    int selectNormalMessageCount();

    int selectImportantMessageCount();

    int updateNormalMessageCount(int normalMessageCount);

    int updateImportantMessageCount(int importantMessageCount);

    MessageCount selectAllMessage();
}
