package domain;

import java.util.Objects;

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

    public Header() {
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

    @Override
    public String toString() {
        return "Header{" +
                "fullName='" + fullName + '\'' +
                ", designation='" + designation + '\'' +
                ", emailId='" + emailId + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", address='" + address + '\'' +
                ", DOB='" + DOB + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Header header = (Header) o;
        return Objects.equals(fullName, header.fullName) && Objects.equals(designation, header.designation) && Objects.equals(emailId, header.emailId) && Objects.equals(contactNumber, header.contactNumber) && Objects.equals(address, header.address) && Objects.equals(DOB, header.DOB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, designation, emailId, contactNumber, address, DOB);
    }
}
