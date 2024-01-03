package functions;
import domain.Header;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderFunctionality {
    public static Header createHeaderFromUserInput(){
        JFrame frame = new JFrame("Enter header information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        JPanel panel = new JPanel(new GridLayout(7,2,10,10));
        panel.setBorder(new EmptyBorder(10,10,10,10));


        JTextField fullNameField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField emailIdField = new JTextField();
        JTextField contactNumberField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField dobField = new JTextField();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(new JLabel("Full name"));
        panel.add(fullNameField);

        panel.add(new JLabel("designation"));
        panel.add(designationField);

        panel.add(new JLabel("emailIdField"));
        panel.add(emailIdField);

        panel.add(new JLabel("contactNumberField"));
        panel.add(contactNumberField);

        panel.add(new JLabel("addressField"));
        panel.add(addressField);

        panel.add(new JLabel("dob : "));
        panel.add(dobField);

        // panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton nextButton = new JButton("Next");

        buttonPanel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(fullNameField,designationField,emailIdField,contactNumberField,addressField,dobField)){
                    frame.dispose();
                }else {
                    JOptionPane.showMessageDialog(frame, "Please fill the required details");
                }
            }
        });
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
        frame.setVisible(true);

        while (frame.isVisible()){
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        String fullNameFieldText = fullNameField.getText();
        String designationFieldText = designationField.getText();
        String emailIdFieldText = emailIdField.getText();
        String contactNumberFieldText = contactNumberField.getText();
        String addressFieldText = addressField.getText();
        String dobFieldText = dobField.getText();
        return new Header(fullNameFieldText,designationFieldText,emailIdFieldText,contactNumberFieldText,addressFieldText,dobFieldText);

    }
    public static boolean validateInput(JTextField... fields){
        for (JTextField field:fields){
            if (field.getText().trim().isEmpty()){
                return false;
            }
        }
        return true;
    }
}