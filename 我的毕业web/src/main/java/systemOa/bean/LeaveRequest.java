package systemOa.bean;

import java.util.Date;

public class LeaveRequest {

    private String messageId;
    private String style;
    private String employeeId;
    private String personName;
    private String department;
    private String  leaveTime;
    private String backTime;
    private String leaveReason;
    private String leaveDetail;
    private  int status;
    private Date applyTime;
    private String applyDays;
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

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getBackTime() {
        return backTime;
    }

    public void setBackTime(String backTime) {
        this.backTime = backTime;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveDetail() {
        return leaveDetail;
    }

    public void setLeaveDetail(String leaveDetail) {
        this.leaveDetail = leaveDetail;
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

    public String getApplyDays() {
        return applyDays;
    }

    public void setApplyDays(String applyDays) {
        this.applyDays = applyDays;
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

    public LeaveRequest(){super();}

    public LeaveRequest(String messageId, String style, String employeeId,
                        String personName, String department, String leaveTime,
                        String backTime, String leaveReason, String leaveDetail,
                        int status, Date applyTime, String applyDays, String provePerson,
                        String proveReason, Date proveTime) {
        this.messageId = messageId;
        this.style = style;
        this.employeeId = employeeId;
        this.personName = personName;
        this.department = department;
        this.leaveTime = leaveTime;
        this.backTime = backTime;
        this.leaveReason = leaveReason;
        this.leaveDetail = leaveDetail;
        this.status = status;
        this.applyTime = applyTime;
        this.applyDays = applyDays;
        this.provePerson = provePerson;
        this.proveReason = proveReason;
        this.proveTime = proveTime;
    }
}
