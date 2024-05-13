import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise_10 extends JFrame {
    private JTextArea textArea;

    public exercise_10() {
        setTitle("Demo Thanh Menu");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Tạo JTextArea để hiển thị văn bản
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Tạo thanh menu
        JMenuBar menuBar = new JMenuBar();

        // Menu File
        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutMenuItem = new JMenuItem("About");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        fileMenu.add(aboutMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Menu Format
        JMenu formatMenu = new JMenu("Format");
        JMenu colorSubMenu = new JMenu("Color");
        JMenuItem redMenuItem = new JMenuItem("Red");
        JMenuItem greenMenuItem = new JMenuItem("Green");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        colorSubMenu.add(redMenuItem);
        colorSubMenu.add(greenMenuItem);
        colorSubMenu.add(blueMenuItem);

        JMenu fontSubMenu = new JMenu("Font");
        JRadioButtonMenuItem font1RadioButton = new JRadioButtonMenuItem("Arial");
        JRadioButtonMenuItem font2RadioButton = new JRadioButtonMenuItem("Roboto");
        JRadioButtonMenuItem font3RadioButton = new JRadioButtonMenuItem("Poppins");
        ButtonGroup fontGroup = new ButtonGroup();
        fontGroup.add(font1RadioButton);
        fontGroup.add(font2RadioButton);
        fontGroup.add(font3RadioButton);

        JCheckBoxMenuItem boldCheckBox = new JCheckBoxMenuItem("Bold");
        JCheckBoxMenuItem italicCheckBox = new JCheckBoxMenuItem("Italic");

        fontSubMenu.add(font1RadioButton);
        fontSubMenu.add(font2RadioButton);
        fontSubMenu.add(font3RadioButton);
        fontSubMenu.addSeparator();
        fontSubMenu.add(boldCheckBox);
        fontSubMenu.add(italicCheckBox);

        formatMenu.add(colorSubMenu);
        formatMenu.add(fontSubMenu);

        // Thêm các menu vào thanh menu
        menuBar.add(fileMenu);
        menuBar.add(formatMenu);

        // Đặt thanh menu cho JFrame
        setJMenuBar(menuBar);

        // Xử lý sự kiện cho các menu item
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(exercise_10.this, "Demo Thanh Menu", "About", JOptionPane.INFORMATION_MESSAGE));

        exitMenuItem.addActionListener(e -> System.exit(0));

        redMenuItem.addActionListener(e -> textArea.setForeground(Color.RED));

        greenMenuItem.addActionListener(e -> textArea.setForeground(Color.GREEN));

        blueMenuItem.addActionListener(e -> textArea.setForeground(Color.BLUE));

        font1RadioButton.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font("Arial", currentFont.getStyle(), currentFont.getSize()));
        });

        font2RadioButton.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font("Roboto", currentFont.getStyle(), currentFont.getSize()));
        });

        font3RadioButton.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            textArea.setFont(new Font("Poppins", currentFont.getStyle(), currentFont.getSize()));
        });

        boldCheckBox.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            if (boldCheckBox.isSelected()) {
                textArea.setFont(new Font(currentFont.getFontName(), Font.BOLD, currentFont.getSize()));
            } else {
                textArea.setFont(new Font(currentFont.getFontName(), Font.PLAIN, currentFont.getSize()));}
        });

        italicCheckBox.addActionListener(e -> {
            Font currentFont = textArea.getFont();
            if (italicCheckBox.isSelected()) {
                textArea.setFont(new Font(currentFont.getFontName(), Font.ITALIC, currentFont.getSize()));
            }

            if (!italicCheckBox.isSelected()){
                textArea.setFont(new Font(currentFont.getFontName(), Font.PLAIN, currentFont.getSize()));
            }
        });

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_10();
    }
}
