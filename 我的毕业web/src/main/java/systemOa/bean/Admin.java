
/*
* 创建超级管理员账号
* account是账号
* password是密码
* name为最后显示的人员名字
* department为部门
* */
package systemOa.bean;

public class Admin {
    private  String account;
    private String password;
    private  String name;
    private String department;
    private int authority;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public Admin(){super();}

    public Admin(String account, String password, String name, String department,int authority) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.department = department;
        this.authority = authority;
    }
}
