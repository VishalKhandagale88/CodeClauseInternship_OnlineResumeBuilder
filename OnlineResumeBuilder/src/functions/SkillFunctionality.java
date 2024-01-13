package functions;

import domain.Skill;

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

public class SkillFunctionality {
    private static final List<Skill> skillsList = new ArrayList<>();
    private static JTextField nameField;

    public static List<Skill> skillsWindow() {
        JFrame skillsFrame = new JFrame("Skills");
        skillsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        skillsFrame.setSize(500, 400);

        skillsFrame.setBackground(new Color(223, 177, 127));

        JPanel skillsPanel = new JPanel();
        skillsPanel.setLayout(new BoxLayout(skillsPanel, BoxLayout.Y_AXIS));
        skillsPanel.setBorder(new EmptyBorder(10, 10, 10, 1));
        skillsPanel.setBackground(new Color(223, 177, 127));

        // Wrap skillsPanel in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(skillsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel initialPanel = addSkillsPanel();
        skillsPanel.add(initialPanel);

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
                Skill skill = new Skill(nameField.getText());
                skillsList.add(skill);
                JPanel newSkillsPanel = addSkillsPanel();
                skillsPanel.add(newSkillsPanel);
                skillsPanel.revalidate();
                skillsFrame.repaint();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInput(nameField)) {
                    Skill skills = new Skill(nameField.getText());
                    skillsList.add(skills);
                    skillsFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(skillsFrame, "Please fill all the required details");
                }
            }
        });

        skillsFrame.getContentPane().setLayout(new BorderLayout());
        // Add the JScrollPane instead of skillsPanel directly
        skillsFrame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        skillsFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        skillsFrame.setVisible(true);

        while (skillsFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return skillsList;
    }

    private static JPanel addSkillsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBackground(new Color(223, 177, 127));

        nameField = createStyledTextField(new JTextField());

        panel.add(new JLabel("Skill Name:"));
        panel.add(nameField);

        return panel;
    }
}
