package systemOa.service;

import systemOa.bean.User;

public interface IUserService {

    public int insertNewUser(User user);

    public int updateUser(String userId);
}

