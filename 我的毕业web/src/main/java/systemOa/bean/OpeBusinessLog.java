package systemOa.bean;

import java.util.Date;

public class OpeBusinessLog {

    private String opePersonId;
    private String opePersonName;
    private String opeBusinessId;
    private String opeBusinessName;
    private String opeAction;
    private Date opeTime;
    private String opeAll;

    public String getOpePersonId() {
        return opePersonId;
    }

    public void setOpePersonId(String opePersonId) {
        this.opePersonId = opePersonId;
    }

    public String getOpePersonName() {
        return opePersonName;
    }

    public void setOpePersonName(String opePersonName) {
        this.opePersonName = opePersonName;
    }

    public String getOpeBusinessId() {
        return opeBusinessId;
    }

    public void setOpeBusinessId(String opeBusinessId) {
        this.opeBusinessId = opeBusinessId;
    }

    public String getOpeBusinessName() {
        return opeBusinessName;
    }

    public void setOpeBusinessName(String opeBusinessName) {
        this.opeBusinessName = opeBusinessName;
    }

    public String getOpeAction() {
        return opeAction;
    }

    public void setOpeAction(String opeAction) {
        this.opeAction = opeAction;
    }

    public Date getOpeTime() {
        return opeTime;
    }

    public void setOpeTime(Date opeTime) {
        this.opeTime = opeTime;
    }

    public String getOpeAll() {
        return opeAll;
    }

    public void setOpeAll(String opeAll) {
        this.opeAll = opeAll;
    }

    public OpeBusinessLog(String opePersonId, String opePersonName, String opeBusinessId,
                          String opeBusinessName, String opeAction, Date opeTime, String opeAll) {
        this.opePersonId = opePersonId;
        this.opePersonName = opePersonName;
        this.opeBusinessId = opeBusinessId;
        this.opeBusinessName = opeBusinessName;
        this.opeAction = opeAction;
        this.opeTime = opeTime;
        this.opeAll = opeAll;
    }
}
