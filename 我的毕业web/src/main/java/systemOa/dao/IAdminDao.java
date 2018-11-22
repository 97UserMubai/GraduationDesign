package systemOa.dao;


import systemOa.bean.Admin;


public interface IAdminDao {
    //登陆的实现，根据账户名查找密码
    Admin selectAdminByAc(String account);

}
