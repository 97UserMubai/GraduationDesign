package systemOa.bean;

import java.util.Date;

public class Message {
    private String messageId;
    private String style;
    private int status;
    private String grade;
    private Date applyTime;
    private String dealPersonName;
    private String dealIdentity;
    private Date dealTime;


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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getDealPersonName() {
        return dealPersonName;
    }

    public void setDealPersonName(String dealPersonName) {
        this.dealPersonName = dealPersonName;
    }

    public String getDealIdentity() {
        return dealIdentity;
    }

    public void setDealIdentity(String dealIdentity) {
        this.dealIdentity = dealIdentity;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Message(){
        super();
    }

    public Message(String messageId, String style, int status, String grade,
                   Date applyTime, String dealPersonName, String dealIdentity, Date dealTime) {
        this.messageId = messageId;
        this.style = style;
        this.status = status;
        this.grade = grade;
        this.applyTime = applyTime;
        this.dealPersonName = dealPersonName;
        this.dealIdentity = dealIdentity;
        this.dealTime = dealTime;
    }
}
