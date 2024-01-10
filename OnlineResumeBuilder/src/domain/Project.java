package domain;

import java.util.Objects;

public class Project {
    private String title;
    private String about;
    private String star;
    private String end;

    public Project(String title, String about, String star, String end) {
        this.title = title;
        this.about = about;
        this.star = star;
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(title, project.title) && Objects.equals(about, project.about) && Objects.equals(star, project.star) && Objects.equals(end, project.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, about, star, end);
    }

    @Override
    public String toString() {
        return "Project{" +
                "title='" + title + '\'' +
                ", about='" + about + '\'' +
                ", star='" + star + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
