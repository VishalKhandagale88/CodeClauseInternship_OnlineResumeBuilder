package functions;


import domain.Education;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


import static utility.ButtonAndTextStyle.createStyledButton;
import static utility.ButtonAndTextStyle.createStyledTextField;
import static validations.Validation.validateInput;

public class EducationFunctionality {
    private static JTextField courseNameFiled;
    private static JTextField instituteNameFiled;
    private static JTextField percentileFiled;
    private static JTextField startYearFiled;
    private static JTextField endYearFiled;
    private static final List<Education> educationList = new ArrayList<>();

    public static List<Education> EducationWindow() {
        JFrame educationFrame = new JFrame("Education");
        educationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        educationFrame.setSize(500, 400);

        educationFrame.setBackground(new Color(223, 177, 127));

        JPanel educationPanel = new JPanel();
        educationPanel.setLayout(new BoxLayout(educationPanel, BoxLayout.Y_AXIS));
        educationPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        educationPanel.setBackground(new Color(223, 177, 127));

        JPanel initialPanel = addEducationPanel();
        educationPanel.add(initialPanel);

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
                Education education = new Education(courseNameFiled.getText(), instituteNameFiled.getText(), percentileFiled.getText(), startYearFiled.getText(), endYearFiled.getText());
                educationList.add(education);
                JPanel newEducationalPanel = addEducationPanel();
                educationPanel.add(newEducationalPanel);
                educationFrame.revalidate();
                educationFrame.repaint();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(courseNameFiled, instituteNameFiled, percentileFiled, startYearFiled, endYearFiled)) {
                    Education education = new Education(courseNameFiled.getText(), instituteNameFiled.getText(), percentileFiled.getText(), startYearFiled.getText(), endYearFiled.getText());
                    educationList.add(education);
                    educationFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(educationFrame, "Please fill all the required details");
                }
            }
        });

        educationFrame.getContentPane().setLayout(new BorderLayout());
        educationFrame.getContentPane().add(BorderLayout.CENTER, educationPanel);
        educationFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        educationFrame.setVisible(true);

        while (educationFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return educationList;
    }

    private static JPanel addEducationPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBackground(new Color(223, 177, 127));

        courseNameFiled = createStyledTextField(new JTextField());
        instituteNameFiled = createStyledTextField(new JTextField());
        percentileFiled = createStyledTextField(new JTextField());
        startYearFiled = createStyledTextField(new JTextField());
        endYearFiled = createStyledTextField(new JTextField());

        panel.add(new JLabel("Course Name:"));
        panel.add(courseNameFiled);
        panel.add(new JLabel("Institute Name:"));
        panel.add(instituteNameFiled);
        panel.add(new JLabel("Percentile:"));
        panel.add(percentileFiled);
        panel.add(new JLabel("Start Year:"));
        panel.add(startYearFiled);
        panel.add(new JLabel("End Year:"));
        panel.add(endYearFiled);

        return panel;
    }


    private static void setEducationField(Education education, JPanel panel, String value) {
        String label = ((JLabel) panel.getComponent(0)).getText(); // Assuming label is at index 0
        switch (label) {
            case "Course Name:":
                education.setCourseName(value);
                break;
            case "Institute Name:":
                education.setInstituteName(value);
                break;
            case "Percentile:":
                education.setPercentile(value);
                break;
            case "Start Year:":
                education.setStartYear(value);
                break;
            case "End Year:":
                education.setEndYear(value);
                break;
            // Add more cases if needed
        }
    }

}
