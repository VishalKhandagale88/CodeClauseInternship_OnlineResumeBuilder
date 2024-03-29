package utility;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ButtonAndTextStyle {
    public static JTextField createStyledTextField(JTextField textField) {
        Border border = BorderFactory.createCompoundBorder(
                new EmptyBorder(0, 5, 0, 5),
                new MatteBorder(0, 0, 1, 0, Color.BLACK));
        textField.setBorder(border);
        textField.setBackground(new Color(223, 177, 127));
        textField.setCaretPosition(0);
        return textField;
    }
    public static JTextArea createStyledTextArea(JTextArea jTextArea) {
        Border border = BorderFactory.createCompoundBorder(
                new EmptyBorder(0, 5, 0, 5),
                new MatteBorder(0, 0, 1, 0, Color.BLACK));
        jTextArea.setBorder(border);
        jTextArea.setBackground(new Color(223, 177, 127));
        jTextArea.setCaretPosition(0);
        return jTextArea;
    }

    public static JPanel createStyledButtonJPanel(String text) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel buttonLabel = new JLabel(text);
        buttonLabel.setForeground(Color.WHITE);
        buttonPanel.add(buttonLabel);
        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                buttonPanel.setBackground(new Color(51, 153, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonPanel.setBackground(new Color(223, 177, 127));
            }
        });
        return buttonPanel;
    }
    public static JButton createStyledButton(String text) {
        JButton styledButton = new JButton(text);
        styledButton.setContentAreaFilled(false);
        styledButton.setBorderPainted(false);
        styledButton.setForeground(Color.WHITE);

        styledButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                styledButton.setBackground(new Color(51, 153, 255));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                styledButton.setBackground(new Color(223, 177, 127));
            }
        });

        return styledButton;
    }
}
