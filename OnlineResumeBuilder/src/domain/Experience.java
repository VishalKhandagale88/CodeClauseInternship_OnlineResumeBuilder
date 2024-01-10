package domain;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(role, that.role) && Objects.equals(description, that.description) && Objects.equals(startYear, that.startYear) && Objects.equals(endYear, that.endYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, role, description, startYear, endYear);
    }
}
