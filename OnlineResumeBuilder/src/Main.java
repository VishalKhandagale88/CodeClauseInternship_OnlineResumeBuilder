import domain.CareerObjective;
import domain.Course;
import domain.Header;
import functions.CareerObjectiveFunctionality;
import functions.CourseFunctionality;
import functions.HeaderFunctionality;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // all objects
//        Header headerFromUserInput = HeaderFunctionality.createHeaderFromUserInput();
//        System.out.println(headerFromUserInput);
//        CareerObjective careerObjective = CareerObjectiveFunctionality.careerObjectiveWindow();
//        System.out.println(careerObjective);

        List<Course> courses = CourseFunctionality.CoursesWindow();
        System.out.println(courses);
    }
}