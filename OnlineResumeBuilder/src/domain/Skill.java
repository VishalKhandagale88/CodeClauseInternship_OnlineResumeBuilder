package domain;

import java.util.Objects;

public class Skill {
    private String title;
    private String name;

    public Skill(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return Objects.equals(title, skill.title) && Objects.equals(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, name);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "title='" + title + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
