package functions;

import domain.CareerObjective;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utility.ButtonAndTextStyle.createStyledButton;

public class CareerObjectiveFunctionality {

    public static void  careerObjectiveWindow(){
        JFrame careerObjectiveFrame = new JFrame("Enter Carrer / About me");
        careerObjectiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        careerObjectiveFrame.setSize(400,300);
        careerObjectiveFrame.setResizable(false);
        careerObjectiveFrame.setBackground(new Color(223,177,127));

        // panel for carrer objective
        JPanel carrerObjectivePanel = new JPanel(new BorderLayout());
        carrerObjectivePanel.setBorder(new EmptyBorder(10,10,10,10));
        carrerObjectivePanel.setBackground(new Color(233,177,127));

        //text area
        JTextArea carrerObjectTextArea = new JTextArea();
        carrerObjectTextArea.setLineWrap(true);
        carrerObjectTextArea.setWrapStyleWord(true);


    }
}
