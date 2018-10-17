package systemOa.dao;


import systemOa.bean.Admin;

/**
 * @ProjectName AirlineSell
 * @ClassName null.java
 * @Author cza
 * @Time 2018/8/3 0003 16:19
 * @Version 1.0
 * @mark null
 * @Description
 */
public interface IAdminDao {
    //登陆的实现，根据账户名查找密码
    Admin selectAdminByAc(String account);

}
