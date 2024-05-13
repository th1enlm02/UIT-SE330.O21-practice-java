import javax.swing.*;
import java.awt.*;

public class exercise_03 extends JFrame {
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton button;

    public exercise_03() {
        setTitle("exercise_03");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        textArea1 = new JTextArea(10, 20);
        textArea2 = new JTextArea(10, 20);
        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        button = new JButton("Copy");

        button.addActionListener(e -> {
            String selectedText = textArea1.getSelectedText();
            if (selectedText != null) {
                System.out.printf("selectedText" + selectedText);
                textArea2.append(selectedText);
            }
            else{
                System.out.println("No selected text.");
            }
        });

        panel.add(scrollPane1, BorderLayout.WEST);
        panel.add(scrollPane2, BorderLayout.EAST);
        panel.add(button, BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new exercise_03();
    }
}
