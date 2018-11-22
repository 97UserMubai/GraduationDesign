package systemOa.dao;

import systemOa.bean.User;

public interface IUserDao {

    int insertNewUser(User user);

    int updateUser(String userId);
}
