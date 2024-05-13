import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_01 extends JFrame {
    private JTextField fieldName;
    private JButton submitButton;

    public exercise_01() {
        setTitle("exercise_01");
        setSize(500, 200);
        setLocationRelativeTo(null);
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

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_01();
    }
}