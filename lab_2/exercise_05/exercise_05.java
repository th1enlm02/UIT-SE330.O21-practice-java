import javax.swing.*;
import java.awt.*;

public class exercise_05 extends JFrame {
    private JButton leftButton, rightButton, topButton, bottomButton, centerButton;

    public exercise_05() {
        setTitle("exercise_05");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        leftButton = new JButton("Trái");
        rightButton = new JButton("Phải");
        topButton = new JButton("Trên");
        bottomButton = new JButton("Dưới");
        centerButton = new JButton("Giữa");

        setLayout(new BorderLayout());

        add(leftButton, BorderLayout.WEST);
        add(rightButton, BorderLayout.EAST);
        add(topButton, BorderLayout.NORTH);
        add(bottomButton, BorderLayout.SOUTH);
        add(centerButton, BorderLayout.CENTER);

        leftButton.addActionListener(e -> {
            leftButton.setVisible(false);
            rightButton.setVisible(true);
            topButton.setVisible(true);
            bottomButton.setVisible(true);
            centerButton.setVisible(true);
        });

        rightButton.addActionListener(e -> {
            rightButton.setVisible(false);
            leftButton.setVisible(true);
            topButton.setVisible(true);
            bottomButton.setVisible(true);
            centerButton.setVisible(true);
        });

        topButton.addActionListener(e -> {
            topButton.setVisible(false);
            leftButton.setVisible(true);
            rightButton.setVisible(true);
            bottomButton.setVisible(true);
            centerButton.setVisible(true);
        });

        bottomButton.addActionListener(e -> {
            bottomButton.setVisible(false);
            leftButton.setVisible(true);
            rightButton.setVisible(true);
            topButton.setVisible(true);
            centerButton.setVisible(true);
        });

        centerButton.addActionListener(e -> {
            centerButton.setVisible(false);
            leftButton.setVisible(true);
            rightButton.setVisible(true);
            topButton.setVisible(true);
            bottomButton.setVisible(true);
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_05();
    }
}
