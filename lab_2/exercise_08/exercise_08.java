import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class exercise_08 extends JFrame {
    private JLabel imageLabel;

    public exercise_08() {
        setTitle("exercise_08");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(imageLabel, BorderLayout.CENTER);

        JButton chooseButton = new JButton("Chọn file");
        chooseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(exercise_08.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                if (isValidImageFile(selectedFile)) {
                    ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
                    imageLabel.setIcon(imageIcon);
                } else {
                    JOptionPane.showMessageDialog(exercise_08.this, "Vui lòng chọn một file hình ảnh!");
                }
            }
        });
        panel.add(chooseButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    private boolean isValidImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".bmp");
    }

    public static void main(String[] args) {
        new exercise_08();
    }
}
