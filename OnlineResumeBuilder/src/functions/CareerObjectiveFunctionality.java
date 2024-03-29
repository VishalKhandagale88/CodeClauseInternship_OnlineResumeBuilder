package functions;

import domain.CareerObjective;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static utility.ButtonAndTextStyle.*;
import static validations.Validation.validateInputTextArea;

public class CareerObjectiveFunctionality {
    private static CareerObjective careerObjective;

    public static CareerObjective careerObjectiveWindow() {

        JFrame careerObjectiveFrame = new JFrame("About me");
        careerObjectiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        careerObjectiveFrame.setSize(500, 400);

        careerObjectiveFrame.setResizable(false);
        careerObjectiveFrame.setBackground(new Color(223, 177, 127));

        // panel for career objective
        JPanel careerObjectivePanel = new JPanel(new BorderLayout());
        careerObjectivePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        careerObjectivePanel.setBackground(new Color(223, 177, 127));

//
        JTextArea description = new JTextArea();
        careerObjectivePanel.add(new JLabel("Description"),BorderLayout.NORTH);
        careerObjectivePanel.add(createStyledTextArea(description));
        description.setLineWrap(true);
        description.setWrapStyleWord(true);

        JPanel gapPanel = new JPanel();
        gapPanel.setBackground(new Color(223, 177, 127));

        JPanel buttonPanel = createStyledButtonJPanel("Next");
        buttonPanel.setBackground(new Color(223, 177, 127));


        careerObjectiveFrame.getContentPane().setLayout(new BorderLayout());
        careerObjectiveFrame.getContentPane().add(BorderLayout.CENTER, careerObjectivePanel);
        careerObjectiveFrame.getContentPane().add(BorderLayout.SOUTH, gapPanel);
        careerObjectiveFrame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
        careerObjectiveFrame.setVisible(true);

        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (validateInputTextArea(description)) {
                    careerObjective = new CareerObjective(description.getText());
                    careerObjectiveFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(careerObjectiveFrame, "Please fill the required details");
                }
            }
        });

        // wait for frame to close before returning
        while (careerObjectiveFrame.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return careerObjective;
    }
}
