package systemOa.bean;

public class Employee {
    private String employeeId;
    private String name;
    private String password;
    private String department;
    private String phone;
    private String identity;
    private int authority;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public Employee(){super();}

    public Employee(String name, String password, String department, String phone, String identity, int authority) {
        this.name = name;
        this.password = password;
        this.department = department;
        this.phone = phone;
        this.identity = identity;
        this.authority = authority;
    }
}
