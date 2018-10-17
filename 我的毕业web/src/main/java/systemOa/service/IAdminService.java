package systemOa.service;
import systemOa.bean.Admin;

/**
 * @ProjectName AirlineSell
 * @ClassName null.java
 * @Author cza
 * @Time 2018/8/3 0003 16:32
 * @Version 1.0
 * @mark null
 * @Description
 */
public interface IAdminService {

    //登陆检查，根据账户名查找密码是否对应
    public Admin checkLogin(String account, String password);

}
