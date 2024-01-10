package domain;

public class Experience {
    private String companyName;
    private String role;
    private String description;
    private String startYear;
    private String endYear;

    public Experience(String companyName, String role, String description, String startYear, String endYear) {
        this.companyName = companyName;
        this.role = role;
        this.description = description;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }
}
