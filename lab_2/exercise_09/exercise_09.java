import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_09 extends JFrame {
    private JTextField textField;
    private JRadioButton regularRadioButton, boldRadioButton, italicRadioButton, boldItalicRadioButton;

    public exercise_09() {
        setTitle("exercise_09");
        setSize(400, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        textField = new JTextField("Lưu Minh Thiện");
        panel.add(textField, BorderLayout.NORTH);

        regularRadioButton = new JRadioButton("Thường", true);
        boldRadioButton = new JRadioButton("Bôi đậm");
        italicRadioButton = new JRadioButton("In nghiêng");
        boldItalicRadioButton = new JRadioButton("Bôi đậm và in nghiêng");

        regularRadioButton.addItemListener(new RadioButtonListener());
        boldRadioButton.addItemListener(new RadioButtonListener());
        italicRadioButton.addItemListener(new RadioButtonListener());
        boldItalicRadioButton.addItemListener(new RadioButtonListener());

        JPanel radioPanel = new JPanel(new GridLayout(4, 1));
        radioPanel.add(regularRadioButton);
        radioPanel.add(boldRadioButton);
        radioPanel.add(italicRadioButton);
        radioPanel.add(boldItalicRadioButton);
        panel.add(radioPanel, BorderLayout.CENTER);

        add(panel);

        setVisible(true);
    }

    private class RadioButtonListener implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            int style = Font.PLAIN;

            if (boldRadioButton.isSelected()) {
                style = Font.BOLD;
            }
            if (italicRadioButton.isSelected()) {
                style = Font.ITALIC;
            }
            if (boldItalicRadioButton.isSelected()) {
                style = Font.BOLD | Font.ITALIC;
            }

            Font font = textField.getFont();
            textField.setFont(new Font(font.getFontName(), style, font.getSize()));
        }
    }

    public static void main(String[] args) {
        new exercise_09();
    }
}
