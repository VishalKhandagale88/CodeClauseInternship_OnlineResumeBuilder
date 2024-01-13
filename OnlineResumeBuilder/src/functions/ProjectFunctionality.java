package functions;

import domain.Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static utility.ButtonAndTextStyle.createStyledButton;
import static utility.ButtonAndTextStyle.createStyledTextField;
import static utility.ButtonAndTextStyle.createStyledTextArea;
import static validations.Validation.validateInput;
import static validations.Validation.validateInputTextArea;

public class ProjectFunctionality {
    private static JTextField titleField;
    private static JTextArea aboutField;
    private static JTextField starField;
    private static JTextField endField;
    private static List<Project> projectList = new ArrayList<>();

    public static List<Project> projectWindow() {
        JFrame projectFrame = new JFrame("Your Projects");
        projectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        projectFrame.setSize(500, 400);

        projectFrame.setBackground(new Color(223, 177, 127));

        JPanel projectPanel = new JPanel();
        projectPanel.setLayout(new BoxLayout(projectPanel, BoxLayout.Y_AXIS));
        projectPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        projectPanel.setBackground(new Color(223, 177, 127));

        JScrollPane scrollPane = new JScrollPane(projectPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // Set the scrollbar policy

        // initial project panel
        JPanel initialProjectPanel = createProjectPanel();
        projectPanel.add(initialProjectPanel);

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
                Project project = new Project(titleField.getText(), aboutField.getText(), starField.getText(), endField.getText());
                projectList.add(project);
                JPanel newCoursePanel = createProjectPanel();
                projectPanel.add(newCoursePanel);
                projectFrame.revalidate();
                projectFrame.repaint();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(titleField, starField, endField) && validateInputTextArea(aboutField)) {
                    Project project = new Project(titleField.getText(), aboutField.getText(), starField.getText(), endField.getText());
                    projectList.add(project);
                    projectFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(projectFrame, "Please fill the required details");
                }
            }
        });

        projectFrame.getContentPane().setLayout(new BorderLayout());
        projectFrame.getContentPane().add(BorderLayout.CENTER, scrollPane); // Add the scroll pane instead of projectPanel
        projectFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        projectFrame.setVisible(true);

        while (projectFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return projectList;
    }

    private static JPanel createProjectPanel() {
        JPanel coursePanel = new JPanel(new GridLayout(4, 1, 2, 2));
        coursePanel.setBackground(new Color(223, 177, 127));

        titleField = createStyledTextField(new JTextField());
        aboutField = createStyledTextArea(new JTextArea());
        starField = createStyledTextField(new JTextField());
        endField = createStyledTextField(new JTextField());
        aboutField.setLineWrap(true); // Enable line wrapping
        aboutField.setWrapStyleWord(true); // Wrap at word boundaries

        coursePanel.add(new JLabel("Project title:"));
        coursePanel.add(titleField);
        coursePanel.add(new JLabel("Started on"));
        coursePanel.add(starField);
        coursePanel.add(new JLabel("ended on"));
        coursePanel.add(endField);
        coursePanel.add(new JLabel("Project Description"));
        coursePanel.add(aboutField);

        return coursePanel;
    }
}
