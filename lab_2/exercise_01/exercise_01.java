import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_01 extends JFrame {
    private JTextField fieldName;
    private JButton submitButton;

    public void exercise_01_dialog() {
        setTitle("Exercise01 Dialog");
        setSize(500, 200);
        setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE
        );

        JPanel panel = new JPanel(new GridLayout(2, 1));

        fieldName = new JTextField();
        panel.add(new JLabel("Enter your name: "));
        panel.add(fieldName);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = fieldName.getText();
                JOptionPane.showMessageDialog(null, "Xin chào " + name);
            }
        });
        panel.add(submitButton);

        add(panel);

        setLocationRelativeTo(null);

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_01().exercise_01_dialog();
    }
}