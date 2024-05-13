import javax.swing.*;
import java.awt.event.*;

public class exercise_02 extends JFrame{
    private JLabel keyLabel;

    public exercise_02() {
        setTitle("exercise_02");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        keyLabel = new JLabel("Press any key");
        keyLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(keyLabel);

        add(panel);

        addKeyListener(new MyKeyListener());

        setVisible(true);

        requestFocus();
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            String keyText = KeyEvent.getKeyText(keyCode);
            keyLabel.setText("Pressed key: " + keyText);
        }
    }

    public static void main(String[] args) {
        new exercise_02();
    }
}