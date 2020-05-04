package Gui;

public class MemberInfo {
    public int userNo, stampNum;
    public String lastName, firstName, email, phoneNo;

    public MemberInfo(int userNo, String lastName, String firstName, String email, String phoneNo, int stampNum) {
        this.userNo = userNo;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.stampNum = stampNum;
    }

    public MemberInfo() {
        userNo = getUserNo();
        lastName = getLastName();
        firstName = getFirstName();
        email = getEmail();
        phoneNo = getPhoneNo();
        stampNum = getStampNum();
    }

    public int getUserNo() {
        return userNo;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
    public int getStampNum() {
        return stampNum;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void setStampNum(int stampNum) {
        this.stampNum = stampNum;
    }
}
