import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import domain.*;
import functions.*;


import java.io.FileNotFoundException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // all objects

//
        Header headerFromUserInput = HeaderFunctionality.createHeaderFromUserInput();
        CareerObjective careerObjective = CareerObjectiveFunctionality.careerObjectiveWindow();
        List<Course> courses = CourseFunctionality.CoursesWindow();
        List<Education> educationList = EducationFunctionality.EducationWindow();
        List<Skill> skills = SkillFunctionality.skillsWindow();
        List<Project> projectList = ProjectFunctionality.projectWindow();
        List<Experience> experienceList = ExperienceFunctionality.experienceWindow();
        String hobbiesWindow = HobbiesFunctionality.createHobbiesWindow();

        PDFGenerator.generateTextFile(headerFromUserInput,careerObjective,courses,
                educationList,skills,projectList,experienceList,hobbiesWindow);

    }
}