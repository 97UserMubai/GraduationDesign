package systemOa.bean;

public class AttendanceCount {

    private String monthId;
    private String employeeId;
    private String personName;
    private String department;
    private int clockInSuccessCount;
    private int knockOffSuccessCount;
    private int clockInFailCount;
    private int knockOffFailCount;

    public int getKnockOffSuccessCount() {
        return knockOffSuccessCount;
    }

    public void setKnockOffSuccessCount(int knockOffSuccessCount) {
        this.knockOffSuccessCount = knockOffSuccessCount;
    }

    public int getKnockOffFailCount() {
        return knockOffFailCount;
    }

    public void setKnockOffFailCount(int knockOffFailCount) {
        this.knockOffFailCount = knockOffFailCount;
    }

    public String getMonthId() {
        return monthId;
    }

    public void setMonthId(String monthId) {
        this.monthId = monthId;
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

    public int getClockInSuccessCount() {
        return clockInSuccessCount;
    }

    public void setClockInSuccessCount(int clockInSuccessCount) {
        this.clockInSuccessCount = clockInSuccessCount;
    }

    public int getClockInFailCount() {
        return clockInFailCount;
    }

    public void setClockInFailCount(int clockInFailCount) {
        this.clockInFailCount = clockInFailCount;
    }

    public AttendanceCount(){super();}

    public AttendanceCount(String monthId, String employeeId,
                           String personName, String department, int clockInSuccessCount,
                           int knockOffSuccessCount, int clockInFailCount, int knockOffFailCount) {
        this.monthId = monthId;
        this.employeeId = employeeId;
        this.personName = personName;
        this.department = department;
        this.clockInSuccessCount = clockInSuccessCount;
        this.knockOffSuccessCount = knockOffSuccessCount;
        this.clockInFailCount = clockInFailCount;
        this.knockOffFailCount = knockOffFailCount;
    }
}
