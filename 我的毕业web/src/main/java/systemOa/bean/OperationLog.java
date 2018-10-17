package systemOa.bean;

import java.util.Date;

public class OperationLog {

    private String opePerson;
    private Date opeTime;
    private String opeAction;
    private String opeAll;

    public String getOpePerson() {
        return opePerson;
    }

    public Date getOpeTime() {
        return opeTime;
    }

    public String getOpeAction() {
        return opeAction;
    }

    public String getOpeAll() {
        return opeAll;
    }

    public void setOpePerson(String opePerson) {
        this.opePerson = opePerson;
    }

    public void setOpeTime(Date opeTime) {
        this.opeTime = opeTime;
    }

    public void setOpeAction(String opeAction) {
        this.opeAction = opeAction;
    }

    public void setOpeAll(String opeAll) {
        this.opeAll = opeAll;
    }
    public OperationLog(){
        super();
    }

    public OperationLog(String opePerson, Date opeTime, String opeAction, String opeAll) {
        this.opePerson = opePerson;
        this.opeTime = opeTime;
        this.opeAction = opeAction;
        this.opeAll = opeAll;
    }
}
