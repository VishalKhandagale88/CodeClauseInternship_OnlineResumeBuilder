import domain.CareerObjective;
import domain.Header;
import functions.CareerObjectiveFunctionality;
import functions.HeaderFunctionality;

public class Main {
    public static void main(String[] args) {
        // all objects
        Header headerFromUserInput = HeaderFunctionality.createHeaderFromUserInput();
        System.out.println(headerFromUserInput);
        CareerObjective careerObjective = CareerObjectiveFunctionality.careerObjectiveWindow();
        System.out.println(careerObjective);
    }
}