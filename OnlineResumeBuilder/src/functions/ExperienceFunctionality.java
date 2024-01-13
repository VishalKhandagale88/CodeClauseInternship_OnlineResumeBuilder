package functions;

import domain.Experience;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static utility.ButtonAndTextStyle.*;
import static validations.Validation.validateInput;
import static validations.Validation.validateInputTextArea;

public class ExperienceFunctionality {
    private static JTextField companyNameField;
    private static JTextField roleField;
    private static JTextArea descriptionField;
    private static JTextField startYearField;
    private static JTextField endYearField;
    private static List<Experience> experienceList = new ArrayList<>();

    public static List<Experience> experienceWindow() {
        JFrame experienceFrame = new JFrame("Your Experience");
        experienceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        experienceFrame.setSize(500, 400);
        experienceFrame.setBackground(new Color(223, 177, 127));

        JPanel experiencePanel = new JPanel();
        experiencePanel.setLayout(new BoxLayout(experiencePanel, BoxLayout.Y_AXIS));
        experiencePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        experiencePanel.setBackground(new Color(223, 177, 127));

        JScrollPane scrollPane = new JScrollPane(experiencePanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // initial experience panel
        JPanel initialExperiencePanel = createExperiencePanel();
        experiencePanel.add(initialExperiencePanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(223, 177, 127));

        JButton addMoreButton = new JButton("Add More");
        addMoreButton.setBackground(new Color(223, 177, 127));

        JButton nextButton = createStyledButton("Next");
        buttonPanel.add(nextButton);
        buttonPanel.add(addMoreButton);

        addMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Experience experience = new Experience(
                        companyNameField.getText(),
                        roleField.getText(),
                        descriptionField.getText(),
                        startYearField.getText(),
                        endYearField.getText()
                );
                experienceList.add(experience);
                JPanel newExperiencePanel = createExperiencePanel();
                experiencePanel.add(newExperiencePanel);
                experienceFrame.revalidate();
                experienceFrame.repaint();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(companyNameField, roleField, startYearField, endYearField) && validateInputTextArea(descriptionField)) {
                    Experience experience = new Experience(
                            companyNameField.getText(),
                            roleField.getText(),
                            descriptionField.getText(),
                            startYearField.getText(),
                            endYearField.getText()
                    );
                    experienceList.add(experience);
                    experienceFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(experienceFrame, "Please fill the required details");
                }
            }
        });

        experienceFrame.getContentPane().setLayout(new BorderLayout());
        experienceFrame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        experienceFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        experienceFrame.setVisible(true);

        while (experienceFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return experienceList;
    }

    private static JPanel createExperiencePanel() {
        JPanel experiencePanel = new JPanel(new GridLayout(5, 2, 2, 2));
        experiencePanel.setBackground(new Color(223, 177, 127));

        companyNameField = createStyledTextField(new JTextField());
        roleField = createStyledTextField(new JTextField());
        descriptionField = createStyledTextArea(new JTextArea());
        startYearField = createStyledTextField(new JTextField());
        endYearField = createStyledTextField(new JTextField());

        descriptionField.setLineWrap(true);
        descriptionField.setWrapStyleWord(true);

        experiencePanel.add(new JLabel("Company Name:"));
        experiencePanel.add(companyNameField);
        experiencePanel.add(new JLabel("Role:"));
        experiencePanel.add(roleField);
        experiencePanel.add(new JLabel("Description:"));
        experiencePanel.add(descriptionField);
        experiencePanel.add(new JLabel("Start Year:"));
        experiencePanel.add(startYearField);
        experiencePanel.add(new JLabel("End Year:"));
        experiencePanel.add(endYearField);

        return experiencePanel;
    }
}
