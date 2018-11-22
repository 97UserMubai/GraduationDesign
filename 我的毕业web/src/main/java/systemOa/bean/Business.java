package systemOa.bean;

import java.util.Date;

public class Business {

    private String businessId;
    private String userId;
    private String employeeId;
    private String userName;
    private String employeeName;
    private String businessName;
    private Date businessProduceTime;
    private int businessStatus;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Date getBusinessProduceTime() {
        return businessProduceTime;
    }

    public void setBusinessProduceTime(Date businessProduceTime) {
        this.businessProduceTime = businessProduceTime;
    }

    public int getBusinessStatus() {
        return businessStatus;
    }

    public void setBusinessStatus(int businessStatus) {
        this.businessStatus = businessStatus;
    }

    public Business(String businessId, String userId, String employeeId, String userName,
                    String employeeName, String businessName, Date businessProduceTime,
                    int businessStatus) {
        this.businessId = businessId;
        this.userId = userId;
        this.employeeId = employeeId;
        this.userName = userName;
        this.employeeName = employeeName;
        this.businessName = businessName;
        this.businessProduceTime = businessProduceTime;
        this.businessStatus = businessStatus;
    }
}
