package systemOa.bean;

import java.util.Date;

public class BusinessUpdateApplication {

    private String messageId;
    private String style;
    private String employeeId;
    private String employeeName;
    private String department;
    private Date applyTime;
    private String applyEvent;
    private String applyReason;
    private String businessId;
    private String businessName;
    private String userId;
    private String userName;
    private int status;
    private String provePerson;
    private String proveReason;
    private Date proveTime;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyEvent() {
        return applyEvent;
    }

    public void setApplyEvent(String applyEvent) {
        this.applyEvent = applyEvent;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getProvePerson() {
        return provePerson;
    }

    public void setProvePerson(String provePerson) {
        this.provePerson = provePerson;
    }

    public String getProveReason() {
        return proveReason;
    }

    public void setProveReason(String proveReason) {
        this.proveReason = proveReason;
    }

    public Date getProveTime() {
        return proveTime;
    }

    public void setProveTime(Date proveTime) {
        this.proveTime = proveTime;
    }

    public BusinessUpdateApplication(String messageId, String style, String employeeId,
                                     String employeeName, String department, Date applyTime,
                                     String applyEvent, String applyReason, String businessId,
                                     String businessName, String userId, String userName,
                                     int status, String provePerson, String proveReason,
                                     Date proveTime) {
        this.messageId = messageId;
        this.style = style;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.applyTime = applyTime;
        this.applyEvent = applyEvent;
        this.applyReason = applyReason;
        this.businessId = businessId;
        this.businessName = businessName;
        this.userId = userId;
        this.userName = userName;
        this.status = status;
        this.provePerson = provePerson;
        this.proveReason = proveReason;
        this.proveTime = proveTime;
    }
}
