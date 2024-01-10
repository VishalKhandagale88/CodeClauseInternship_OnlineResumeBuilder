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

}
