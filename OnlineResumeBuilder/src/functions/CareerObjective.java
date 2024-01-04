package functions;

import java.util.Objects;

public class CareerObjective {
    private String description;

    public CareerObjective(String description) {
        this.description = description;
    }

    public String getTitle() {
        return "About Me";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerObjective that = (CareerObjective) o;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return "CareerObjective{" +
                "description='" + description + '\'' +
                '}';
    }
}
