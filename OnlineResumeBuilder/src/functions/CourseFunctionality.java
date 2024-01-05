package functions;

import domain.Course;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static utility.ButtonAndTextStyle.createStyledTextField;

public class CourseFunctionality {
    private static List<Course> course = new ArrayList<>();
    public static List<Course> CoursesWindow(){
        JFrame coursesFrame = new JFrame();
        coursesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        coursesFrame.setSize(400,300);
        coursesFrame.setBackground(new Color(223,177,127));

        // course panel
        JPanel coursePanel = new JPanel();
        coursePanel.setLayout(new BoxLayout(coursePanel,BoxLayout.Y_AXIS));
        coursePanel.setBorder(new EmptyBorder(10,10,10,10));
        coursePanel.setBackground(new Color(223,177,127));

        // initial course panel
        JPanel initialCoursePanel = createCoursePanel();
        coursePanel.add(initialCoursePanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(223,177,127));

        // button to add more courses
        JButton addMoreButton =  new JButton("Add More");
        addMoreButton.setBackground(new Color(223,177,127));
        addMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel newCoursePanel = createCoursePanel();
                coursePanel.add(newCoursePanel);
                coursesFrame.revalidate();
                coursesFrame.repaint();
            }
        });
        buttonPanel.add(addMoreButton);
        coursesFrame.getContentPane().setLayout(new BorderLayout());
        coursesFrame.getContentPane().add(BorderLayout.CENTER,coursePanel);
        coursesFrame.getContentPane().add(BorderLayout.SOUTH,buttonPanel);
        coursesFrame.setVisible(true);

        // wait for frame to close before returning
        while (coursesFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return course;
    }
    private static JPanel createCoursePanel() {
        JPanel coursePanel = new JPanel(new GridLayout(2, 2, 2, 2));
        coursePanel.setBackground(new Color(223, 177, 127));

        JTextField courseNameField = createStyledTextField(new JTextField());
        JTextField courseDescriptionField = createStyledTextField(new JTextField());

        coursePanel.add(new JLabel("Course Name:"));
        coursePanel.add(courseNameField);
        coursePanel.add(new JLabel("Course Description:"));
        coursePanel.add(courseDescriptionField);

        return coursePanel;
    }
}
