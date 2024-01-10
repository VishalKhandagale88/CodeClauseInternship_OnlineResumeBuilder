package functions;

import domain.Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static utility.ButtonAndTextStyle.createStyledTextField;

public class ProjectFunctionality {
    private static JTextField  titleField;
    private static JTextField aboutField;
    private static JTextField starField;
    private static JTextField endField;
    private static List<Project> projectList = new ArrayList<>();

    public static List<Project> projectWindow(){
        JFrame projectFrame = new JFrame();
        projectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        projectFrame.setSize(400,300);
        projectFrame.setBackground(new Color(223,177,127));

        JPanel projectPanel = new JPanel();
        projectPanel.setLayout(new BoxLayout(projectPanel,BoxLayout.Y_AXIS));
        projectPanel.setBorder(new EmptyBorder(10,10,10,10));
        projectPanel.setBackground(new Color(223,177,127));

        // initial project panel
        JPanel initialProjectPanel = createProjectPanel();


        return projectList;
    }

    private static JPanel createProjectPanel() {
        JPanel coursePanel = new JPanel(new GridLayout(2, 2, 2, 2));
        coursePanel.setBackground(new Color(223, 177, 127));

        titleField = createStyledTextField(new JTextField());
        aboutField = createStyledTextField(new JTextField());
        starField = createStyledTextField(new JTextField());
        endField = createStyledTextField(new JTextField());
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
