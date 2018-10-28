package systemOa.service;
import systemOa.bean.Admin;


public interface IAdminService {

    //登陆检查，根据账户名查找密码是否对应
    public Admin checkLogin(String account, String password);

}
