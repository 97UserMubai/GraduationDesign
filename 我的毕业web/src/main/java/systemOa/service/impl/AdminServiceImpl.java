package systemOa.service.impl;

import systemOa.bean.Admin;
import systemOa.dao.IAdminDao;
import systemOa.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements IAdminService {
    @Autowired
    @Qualifier("IAdminDao")
    private IAdminDao adminDao;

    public IAdminDao getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(IAdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin checkLogin(String account, String password) {
        Admin admin = adminDao.selectAdminByAc(account);
//        System.out.println("测试语句");
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else {
            return null;
        }
    }
}
