package systemOa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import systemOa.bean.User;
import systemOa.dao.IUserDao;
import systemOa.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    @Qualifier("IUserDao")
    private IUserDao iUserDao;

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }

    @Override
    public int insertNewUser(User user) {
        return iUserDao.insertNewUser(user);
    }

    @Override
    public int updateUser(String userId) {
        return iUserDao.updateUser(userId);
    }
}
