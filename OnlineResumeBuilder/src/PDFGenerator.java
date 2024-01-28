import domain.CareerObjective;
import domain.Course;
import domain.Header;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PDFGenerator {

    static void generateTextFile(Header header, CareerObjective careerObjective, List<Course> courses) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("D:\\New folder\\code clause internship\\resume--demo.txt"))) {
            // Writing values to the file
            writer.println("Name: " + header.getFullName());
            writer.println("Designation: " + header.getDesignation());
            writer.println("Email : "+ header.getEmailId());
            writer.println("contact number : "+ header.getContactNumber());
            writer.println("address : "+header.getAddress());
            writer.println("Date of Birth : "+header.getDOB());
            writer.println("**************************************************************");
            writer.println("Carrer Objective");
            writer.println(careerObjective);
            writer.println("**************************************************************");
            writer.println("Courses");
            for (Course course : courses){
                writer.println("Name : "+ course.getName());
                writer.println(("Description : "+ course.getDescription()));
                writer.println("-------------------------------------------------------------------");
            }
            writer.println("**************************************************************");



            System.out.println("Values written to the file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
}
