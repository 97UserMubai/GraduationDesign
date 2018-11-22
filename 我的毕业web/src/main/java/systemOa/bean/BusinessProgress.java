package systemOa.bean;

import java.util.Date;

public class BusinessProgress {

    private String businessId;
    private String businessName;
    private String progressTitle;
    private String progressDetail;
    private int progressLabel;
    private int progressStatus;
    private Date modifyTime;

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

    public String getProgressTitle() {
        return progressTitle;
    }

    public void setProgressTitle(String progressTitle) {
        this.progressTitle = progressTitle;
    }

    public String getProgressDetail() {
        return progressDetail;
    }

    public void setProgressDetail(String progressDetail) {
        this.progressDetail = progressDetail;
    }

    public int getProgressLabel() {
        return progressLabel;
    }

    public void setProgressLabel(int progressLabel) {
        this.progressLabel = progressLabel;
    }

    public int getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(int progressStatus) {
        this.progressStatus = progressStatus;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public BusinessProgress(String businessId, String businessName, String progressTitle,
                            String progressDetail, int progressLabel, int progressStatus,
                            Date modifyTime) {
        this.businessId = businessId;
        this.businessName = businessName;
        this.progressTitle = progressTitle;
        this.progressDetail = progressDetail;
        this.progressLabel = progressLabel;
        this.progressStatus = progressStatus;
        this.modifyTime = modifyTime;
    }

}
