package functions;

import domain.Header;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static functions.ButtonAndTextStyle.createStyledButton;
import static functions.ButtonAndTextStyle.createStyledTextField;

public class HeaderFunctionality {
    public static Header createHeaderFromUserInput() {
        JFrame frame = new JFrame("Enter header information");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setResizable(false);
        frame.setBackground(new Color(223, 177, 127));

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Set padding for all sides
        panel.setBackground(new Color(223, 177, 127));

        JTextField fullNameField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField emailIdField = new JTextField();
        JTextField contactNumberField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField dobField = new JTextField();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Full name"));
        panel.add(createStyledTextField(fullNameField));

        panel.add(new JLabel("designation"));
        panel.add(createStyledTextField(designationField));

        panel.add(new JLabel("emailIdField"));
        panel.add(createStyledTextField(emailIdField));

        panel.add(new JLabel("contactNumberField"));
        panel.add(createStyledTextField(contactNumberField));

        panel.add(new JLabel("addressField"));
        panel.add(createStyledTextField(addressField));

        panel.add(new JLabel("dob : "));
        panel.add(createStyledTextField(dobField));

        // Create an empty panel to act as the visual gap
        JPanel gapPanel = new JPanel();
        gapPanel.setBackground(new Color(223, 177, 127));

        JPanel buttonPanel = createStyledButton("Next");
        buttonPanel.setBackground(new Color(223, 177, 127));

        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, gapPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        frame.setVisible(true);

        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (validateInput(fullNameField, designationField, emailIdField, contactNumberField, addressField, dobField)) {
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Please fill the required details");
                }
            }
        });

        String fullNameFieldText = fullNameField.getText();
        String designationFieldText = designationField.getText();
        String emailIdFieldText = emailIdField.getText();
        String contactNumberFieldText = contactNumberField.getText();
        String addressFieldText = addressField.getText();
        String dobFieldText = dobField.getText();
        return new Header(fullNameFieldText, designationFieldText, emailIdFieldText, contactNumberFieldText, addressFieldText, dobFieldText);
    }



    public static boolean validateInput(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
