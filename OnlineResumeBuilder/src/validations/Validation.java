package validations;

import javax.swing.*;

public class Validation {
    public static boolean validateInput(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
