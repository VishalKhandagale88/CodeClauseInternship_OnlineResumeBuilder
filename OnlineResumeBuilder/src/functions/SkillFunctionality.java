package functions;

import domain.Skill;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static utility.ButtonAndTextStyle.createStyledTextField;

public class SkillFunctionality {
    private static final List<Skill> skillsList = new ArrayList<>();
    private static JTextField titleFiled;
    private static JTextField nameField;

    public static List<Skill> skillsWindow() {
        JFrame skillsFrame = new JFrame("Skills");
        skillsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        skillsFrame.setSize(400, 300);
        skillsFrame.setBackground(new Color(223, 177, 127));

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new BoxLayout(skillsPanel, BoxLayout.Y_AXIS));
        skillsPanel.setBorder(new EmptyBorder(10, 10, 10, 1));
        skillsPanel.setBackground(new Color(223, 177, 127));

        JPanel initialPanel = addSkillsPanel();
        skillsPanel.add(initialPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(223,177,127));


        return skillsList;
    }

    private static JPanel addSkillsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBackground(new Color(223, 177, 127));

        titleFiled = createStyledTextField(new JTextField());
        nameField = createStyledTextField(new JTextField());

        panel.add(new JLabel("Course Name:"));
        panel.add(titleFiled);
        panel.add(new JLabel("Institute Name:"));
        panel.add(nameField);


        return panel;
    }

}
