import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_07 extends JFrame {
    private Color[] colors = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    private String[] colorNames = {"Đen", "Trắng", "Đỏ", "Xanh dương", "Xanh lá cây", "Vàng"};
    private JPanel colorPanel;
    private ButtonGroup colorGroup;

    public exercise_07() {
        setTitle("exercise_07");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(200, 200));
        colorPanel.setBackground(Color.WHITE);

        JPanel radioButtonPanel = new JPanel(new GridLayout(0, 1));
        colorGroup = new ButtonGroup();
        for (int i = 0; i < colors.length; i++) {
            JRadioButton radioButton = new JRadioButton(colorNames[i]);
            radioButton.addActionListener(new ColorSelectionListener(colors[i]));
            colorGroup.add(radioButton);
            radioButtonPanel.add(radioButton);
        }

        panel.add(colorPanel, BorderLayout.CENTER);
        panel.add(radioButtonPanel, BorderLayout.EAST);

        add(panel);

        setVisible(true);
    }

    private class ColorSelectionListener implements ActionListener {
        private Color color;

        public ColorSelectionListener(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent e) {
            colorPanel.setBackground(color);
        }
    }

    public static void main(String[] args) {
        new exercise_07();
    }
}
