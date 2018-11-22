package systemOa.bean;

import java.util.Date;

public class UserApplyLog {

    private String userId;
    private String userName;
    private String businessId;
    private String businessName;
    private int progressLabel;
    private Date businessOverTime;

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

    public int getProgressLabel() {
        return progressLabel;
    }

    public void setProgressLabel(int progressLabel) {
        this.progressLabel = progressLabel;
    }

    public Date getBusinessOverTime() {
        return businessOverTime;
    }

    public void setBusinessOverTime(Date businessOverTime) {
        this.businessOverTime = businessOverTime;
    }

    public UserApplyLog(String userId, String userName, String businessId,
                        String businessName, int progressLabel, Date businessOverTime) {
        this.userId = userId;
        this.userName = userName;
        this.businessId = businessId;
        this.businessName = businessName;
        this.progressLabel = progressLabel;
        this.businessOverTime = businessOverTime;
    }
}
