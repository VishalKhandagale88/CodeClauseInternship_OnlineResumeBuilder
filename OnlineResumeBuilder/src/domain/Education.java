package domain;

public class Education {
    private String courseName;
    private String instituteName;
    private String percentile;
    private String startYear;
    private String endYear;

    public Education(String courseName, String instituteName, String percentile, String startYear, String endYear) {
        this.courseName = courseName;
        this.instituteName = instituteName;
        this.percentile = percentile;
        this.startYear = startYear;
        this.endYear = endYear;
    }


}
