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

    public static JPanel createStyledButton(String text) {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel buttonLabel = new JLabel(text);
        buttonLabel.setForeground(Color.WHITE);
        buttonPanel.add(buttonLabel);
        buttonPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Handle button click
            }

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
}
