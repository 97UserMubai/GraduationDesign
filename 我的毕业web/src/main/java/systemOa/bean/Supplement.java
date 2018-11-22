package systemOa.bean;

import java.util.Date;

public class Supplement {
    private String messageId;
    private String style;
    private String employeeId;
    private String personName;
    private String department;
    private Date supplementDay;
    private String supplementTime;
    private String supplementReason;
    private String supplementDetail;
    private int status;
    private Date applyTime;
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

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getSupplementDay() {
        return supplementDay;
    }

    public void setSupplementDay(Date supplementDay) {
        this.supplementDay = supplementDay;
    }

    public String getSupplementTime() {
        return supplementTime;
    }

    public void setSupplementTime(String supplementTime) {
        this.supplementTime = supplementTime;
    }

    public String getSupplementReason() {
        return supplementReason;
    }

    public void setSupplementReason(String supplementReason) {
        this.supplementReason = supplementReason;
    }

    public String getSupplementDetail() {
        return supplementDetail;
    }

    public void setSupplementDetail(String supplementDetail) {
        this.supplementDetail = supplementDetail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
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

    public Supplement(){super();}

    public Supplement(String messageId, String style, String employeeId,
                      String personName, String department, Date supplementDay,
                      String supplementTime, String supplementReason,
                      String supplementDetail, int status, Date applyTime,
                      String provePerson, String proveReason, Date proveTime) {
        this.messageId = messageId;
        this.style = style;
        this.employeeId = employeeId;
        this.personName = personName;
        this.department = department;
        this.supplementDay = supplementDay;
        this.supplementTime = supplementTime;
        this.supplementReason = supplementReason;
        this.supplementDetail = supplementDetail;
        this.status = status;
        this.applyTime = applyTime;
        this.provePerson = provePerson;
        this.proveReason = proveReason;
        this.proveTime = proveTime;
    }
}
