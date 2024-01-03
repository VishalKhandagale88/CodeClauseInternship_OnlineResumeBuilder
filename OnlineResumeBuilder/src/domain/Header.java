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


}
