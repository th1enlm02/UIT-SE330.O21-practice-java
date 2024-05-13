import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_04 extends JFrame {
    private JButton leftButton, centerButton, rightButton;
    public exercise_04() {
        setTitle("exercise_04");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        leftButton = new JButton("Trái");
        centerButton = new JButton("Giữa");
        rightButton = new JButton("Phải");

        leftButton.addActionListener(e -> {
            panel.setLayout(new FlowLayout(FlowLayout.LEFT));
            panel.revalidate();
            panel.repaint();
        });

        centerButton.addActionListener(e -> {
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));
            panel.revalidate();
            panel.repaint();
        });

        rightButton.addActionListener(e -> {
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            panel.revalidate();
            panel.repaint();
        });

        panel.add(leftButton);
        panel.add(centerButton);
        panel.add(rightButton);

        add(panel);

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_04();
    }
}
