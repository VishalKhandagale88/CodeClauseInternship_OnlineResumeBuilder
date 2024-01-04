import domain.Header;
import functions.HeaderFunctionality;

public class Main {
    public static void main(String[] args) {
        // all objects
        Header headerFromUserInput = HeaderFunctionality.createHeaderFromUserInput();
        if (headerFromUserInput!=null){
            System.out.println("user header information");
            System.out.println(headerFromUserInput);
        }else {
            System.out.println("User canceled the input");
        }
    }
}