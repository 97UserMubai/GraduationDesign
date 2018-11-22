package systemOa.bean;

public class User {

    private String userId;
    private String userName;
    private String userSex;
    private String userPhone;
    private String userPinCode;
    private String userHomeAddress;
    private String userHopeStoreLocation;
    private String userHopeCost;

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

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPinCode() {
        return userPinCode;
    }

    public void setUserPinCode(String userPinCode) {
        this.userPinCode = userPinCode;
    }

    public String getUserHomeAddress() {
        return userHomeAddress;
    }

    public void setUserHomeAddress(String userHomeAddress) {
        this.userHomeAddress = userHomeAddress;
    }

    public String getUserHopeStoreLocation() {
        return userHopeStoreLocation;
    }

    public void setUserHopeStoreLocation(String userHopeStoreLocation) {
        this.userHopeStoreLocation = userHopeStoreLocation;
    }

    public String getUserHopeCost() {
        return userHopeCost;
    }

    public void setUserHopeCost(String userHopeCost) {
        this.userHopeCost = userHopeCost;
    }

    public User(String userId, String userName, String userSex, String userPhone,
                String userPinCode, String userHomeAddress, String userHopeStoreLocation,
                String userHopeCost) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userPhone = userPhone;
        this.userPinCode = userPinCode;
        this.userHomeAddress = userHomeAddress;
        this.userHopeStoreLocation = userHopeStoreLocation;
        this.userHopeCost = userHopeCost;
    }
}
