import javax.swing.*;
import java.awt.*;

public class exercise_06 extends JFrame {
    private JList<String> genreList;
    private JButton submitButton;

    public exercise_06() {
        setTitle("exercise_06");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        String[] genres = {"Văn học", "Khoa học", "Lịch sử", "Công nghệ", "Thể thao", "Văn hóa"};

        genreList = new JList<>(genres);
        genreList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(genreList);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            Object[] selectedGenres = genreList.getSelectedValues();

            StringBuilder selectedGenresStr = new StringBuilder("Các thể loại sách đã chọn:\n");
            for (Object genre : selectedGenres) {
                selectedGenresStr.append(genre).append("\n");
            }
            JOptionPane.showMessageDialog(exercise_06.this, selectedGenresStr.toString());
        });

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(submitButton, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }
    public static void main(String[] args) {
        new exercise_06();
    }
}
