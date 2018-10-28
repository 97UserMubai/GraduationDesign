package systemOa.bean;

import java.util.Date;

public class Attendance {

    private String monthId;
    private int monthDay;
    private String weekDay;
    private String employeeId;
    private String department;
    private String personName;
    private Date clockInTime;
    private Date knockOffTime;
    private int clockInStatus;
    private int knockOffStatus;

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId;
    }

    public int getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(int monthDay) {
        this.monthDay = monthDay;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getClockInTime() {
        return clockInTime;
    }

    public void setClockInTime(Date clockInTime) {
        this.clockInTime = clockInTime;
    }

    public Date getKnockOffTime() {
        return knockOffTime;
    }

    public void setKnockOffTime(Date knockOffTime) {
        this.knockOffTime = knockOffTime;
    }

    public int getClockInStatus() {
        return clockInStatus;
    }

    public void setClockInStatus(int clockInStatus) {
        this.clockInStatus = clockInStatus;
    }

    public int getKnockOffStatus() {
        return knockOffStatus;
    }

    public void setKnockOffStatus(int knockOffStatus) {
        this.knockOffStatus = knockOffStatus;
    }

    public Attendance(){super();}



    public Attendance(String monthId, int monthDay, String weekDay, String employeeId, String department,
                      String personName, Date clockInTime, Date knockOffTime, int clockInStatus, int knockOffStatus) {
        this.monthId = monthId;
        this.monthDay = monthDay;
        this.weekDay = weekDay;
        this.employeeId = employeeId;
        this.department = department;
        this.personName = personName;
        this.clockInTime = clockInTime;
        this.knockOffTime = knockOffTime;
        this.clockInStatus = clockInStatus;
        this.knockOffStatus = knockOffStatus;
    }
}
