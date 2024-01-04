package functions;
import domain.Header;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HeaderFunctionality {
    public static Header createHeaderFromUserInput(){
        JFrame frame = new JFrame("Enter header information");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);

        // make window non-resizable
        frame.setResizable(false);
        // set background color for the entire frame
        frame.setBackground(new Color(223, 177, 127));

        JPanel panel = new JPanel(new GridLayout(7,2,10,10));
        panel.setBorder(new EmptyBorder(10,10,10,10));

        // set background color for the panel
        panel.setBackground(new Color(223, 177, 127));

        JTextField fullNameField = new JTextField();
        JTextField designationField = new JTextField();
        JTextField emailIdField = new JTextField();
        JTextField contactNumberField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField dobField = new JTextField();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

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

        // panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JButton nextButton = new JButton("Next");
        buttonPanel.setBackground(new Color(223, 177, 127));
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
    public static JTextField createStyledTextField(JTextField textField){
        Border border = BorderFactory.createCompoundBorder(
                new EmptyBorder(0,5,0,5),
                new MatteBorder(0,0,1,0,Color.BLACK));
        textField.setBorder(border);
        textField.setBackground(new Color(223, 177, 127));
        textField.setCaretPosition(0);
        return textField;
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
