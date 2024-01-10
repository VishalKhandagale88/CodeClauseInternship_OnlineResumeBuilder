import domain.*;
import functions.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // all objects

//
//        Header headerFromUserInput = HeaderFunctionality.createHeaderFromUserInput();
//        System.out.println(headerFromUserInput);
//        CareerObjective careerObjective = CareerObjectiveFunctionality.careerObjectiveWindow();
//        System.out.println(careerObjective);
//
//        List<Course> courses = CourseFunctionality.CoursesWindow();
//        System.out.println(courses);
//
//        List<Education> educationList = EducationFunctionality.EducationWindow();
//        System.out.println(educationList);

        List<Skill> skills = SkillFunctionality.skillsWindow();
        System.out.println(skills);
    }
}