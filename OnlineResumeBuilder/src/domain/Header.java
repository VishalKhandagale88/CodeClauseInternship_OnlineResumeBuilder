package domain;

public class Header {
    private String fullName;
    private String designation;
    private String emailId;
    private String contactNumber;
    private String address;
    private String DOB;

    public Header(String fullName, String designation, String emailId, String contactNumber, String address, String DOB) {
        this.fullName = fullName;
        this.designation = designation;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.address = address;
        this.DOB = DOB;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
