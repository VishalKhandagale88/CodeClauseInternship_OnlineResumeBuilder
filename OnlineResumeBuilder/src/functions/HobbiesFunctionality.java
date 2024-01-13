package functions;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utility.ButtonAndTextStyle.createStyledButton;
import static utility.ButtonAndTextStyle.createStyledTextField;
import static validations.Validation.validateInput;

public class HobbiesFunctionality {
    private static JTextField inputField;
    private static String enteredText;


    public static String createHobbiesWindow() {
        JFrame inputFrame = new JFrame("Single Input");
        inputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inputFrame.setSize(400, 150);
        inputFrame.setBackground(new Color(223, 177, 127));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        inputPanel.setBackground(new Color(223, 177, 127));

        inputField = createStyledTextField(new JTextField());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(223, 177, 127));

        JButton nextButton = createStyledButton("Next");
        buttonPanel.add(nextButton);

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(inputField)) {
                    enteredText = inputField.getText();
                    inputFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(inputFrame, "Please fill the required details");
                }
            }
        });

        inputPanel.add(new JLabel("Enter Text:"));
        inputPanel.add(inputField);

        inputFrame.getContentPane().setLayout(new BorderLayout());
        inputFrame.getContentPane().add(BorderLayout.CENTER, inputPanel);
        inputFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        inputFrame.setVisible(true);

        while (inputFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  enteredText;
    }
}
