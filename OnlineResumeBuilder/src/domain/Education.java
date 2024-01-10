package domain;

import java.util.Objects;

public class Education {
    private String courseName;
    private String instituteName;
    private String percentile;
    private String startYear;
    private String endYear;

    public Education() {

    }

    public Education(String courseName, String instituteName, String percentile, String startYear, String endYear) {
        this.courseName = courseName;
        this.instituteName = instituteName;
        this.percentile = percentile;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getPercentile() {
        return percentile;
    }

    public void setPercentile(String percentile) {
        this.percentile = percentile;
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
    public String toString() {
        return "Education{" +
                "courseName='" + courseName + '\'' +
                ", instituteName='" + instituteName + '\'' +
                ", percentile='" + percentile + '\'' +
                ", startYear='" + startYear + '\'' +
                ", endYear='" + endYear + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Objects.equals(courseName, education.courseName) && Objects.equals(instituteName, education.instituteName) && Objects.equals(percentile, education.percentile) && Objects.equals(startYear, education.startYear) && Objects.equals(endYear, education.endYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, instituteName, percentile, startYear, endYear);
    }
}
