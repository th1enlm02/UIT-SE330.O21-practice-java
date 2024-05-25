package lab_3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class exercise_05 extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel studentPanel, classPanel;
    private JButton addStudentButton, deleteStudentButton, updateStudentButton, searchStudentButton;
    private JButton addClassButton, deleteClassButton, updateClassButton;
    private JTextField studentIdField, studentNameField, studentClassField, studentGPAField;
    private JTextField classIdField, classNameField, classTeacherField;
    private JTextField searchField1, searchField2;
    private JComboBox<String> searchComboBox;
    private Connection conn;
    private JTable resultTable;
    private DefaultTableModel tableModel;
    private JRadioButton ascendRadioButton, descendRadioButton;

    public exercise_05() {
        setTitle("Quản lý Sinh viên và Lớp học");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Panel Sinh Viên
        studentPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        addStudentButton = new JButton("Thêm Sinh Viên");
        deleteStudentButton = new JButton("Xóa Sinh Viên");
        updateStudentButton = new JButton("Cập nhật Sinh Viên");
        searchStudentButton = new JButton("Tìm");

        studentIdField = new JTextField(40);
        studentNameField = new JTextField(40);
        studentClassField = new JTextField(40);
        studentGPAField = new JTextField(40);

        searchComboBox = new JComboBox<>(new String[]{"Mã SV", "Họ tên", "Lớp", "Điểm TB"});
        searchField1 = new JTextField(15);
        searchField2 = new JTextField(15);

        resultTable = new JTable();
        tableModel = new DefaultTableModel(new String[]{"Mã SV", "Họ Tên", "Lớp", "Điểm TB"}, 0);
        resultTable.setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);

        searchComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSearchFields();
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        studentPanel.add(new JLabel("Mã SV:"), gbc);

        gbc.gridx = 1;
        studentPanel.add(studentIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        studentPanel.add(new JLabel("Họ Tên:"), gbc);

        gbc.gridx = 1;
        studentPanel.add(studentNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        studentPanel.add(new JLabel("Lớp:"), gbc);

        gbc.gridx = 1;
        studentPanel.add(studentClassField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        studentPanel.add(new JLabel("Điểm TB:"), gbc);

        gbc.gridx = 1;
        studentPanel.add(studentGPAField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        studentPanel.add(addStudentButton, gbc);

        gbc.gridy = 5;
        studentPanel.add(deleteStudentButton, gbc);

        gbc.gridy = 6;
        studentPanel.add(updateStudentButton, gbc);

        gbc.gridy = 7;
        studentPanel.add(new JLabel("Tìm kiếm:"), gbc);

        gbc.gridy = 8;
        gbc.gridwidth = 1;
        studentPanel.add(searchComboBox, gbc);

        gbc.gridx = 1;
        studentPanel.add(searchField1, gbc);

        gbc.gridx = 2;
        studentPanel.add(searchField2, gbc);

        gbc.gridx = 3;
        studentPanel.add(searchStudentButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        studentPanel.add(scrollPane, gbc);

        // Add radio buttons for sorting
        ascendRadioButton = new JRadioButton("Tăng dần");
        descendRadioButton = new JRadioButton("Giảm dần");
        ButtonGroup group = new ButtonGroup();
        group.add(ascendRadioButton);
        group.add(descendRadioButton);

        gbc.gridy = 10;
        studentPanel.add(ascendRadioButton, gbc);
        gbc.gridy = 11;
        studentPanel.add(descendRadioButton, gbc);

        // Panel Lớp
        classPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        addClassButton = new JButton("Thêm Lớp");
        deleteClassButton = new JButton("Xóa Lớp");
        updateClassButton = new JButton("Cập nhật Lớp");

        classIdField = new JTextField(15);
        classNameField = new JTextField(15);
        classTeacherField = new JTextField(15);

        gbc.gridx = 0;
        gbc.gridy = 0;
        classPanel.add(new JLabel("Mã Lớp:"), gbc);

        gbc.gridx = 1;
        classPanel.add(classIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        classPanel.add(new JLabel("Tên Lớp:"), gbc);

        gbc.gridx = 1;
        classPanel.add(classNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        classPanel.add(new JLabel("CVHT:"), gbc);

        gbc.gridx = 1;
        classPanel.add(classTeacherField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        classPanel.add(addClassButton, gbc);

        gbc.gridy = 4;
        classPanel.add(deleteClassButton, gbc);

        gbc.gridy = 5;
        classPanel.add(updateClassButton, gbc);

        tabbedPane.addTab("Sinh Viên", studentPanel);
        tabbedPane.addTab("Lớp", classPanel);

        add(tabbedPane);

        // Kết nối cơ sở dữ liệu
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
            conn = DriverManager.getConnection(connectionUrl);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStudent();
            }
        });

        updateStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudent();
            }
        });

        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addClass();
            }
        });

        deleteClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteClass();
            }
        });

        updateClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateClass();
            }
        });

        searchStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });

        ascendRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortStudentsByGPA(true);
            }
        });

        descendRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortStudentsByGPA(false);
            }
        });

        updateSearchFields();
    }

    private void updateSearchFields() {
        String selectedOption = (String) searchComboBox.getSelectedItem();
        searchField1.setVisible(true);
        searchField2.setVisible(false);
        if ("Điểm TB".equals(selectedOption)) {
            searchField2.setVisible(true);
        }
        revalidate();
        repaint();
    }

    private void addStudent() {
        String id = studentIdField.getText();
        String name = studentNameField.getText();
        String className = studentClassField.getText();
        String gpa = studentGPAField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO SinhVien (MaSV, HoTen, Lop, DiemTB) VALUES (?, ?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, className);
            statement.setString(4, gpa);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm sinh viên thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteStudent() {
        String id = studentIdField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM SinhVien WHERE MaSV = ?");
            statement.setString(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Xóa sinh viên thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateStudent() {
        String id = studentIdField.getText();
        String name = studentNameField.getText();
        String className = studentClassField.getText();
        String gpa = studentGPAField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE SinhVien SET HoTen = ?, Lop = ?, DiemTB = ? WHERE MaSV = ?");
            statement.setString(1, name);
            statement.setString(2, className);
            statement.setString(3, gpa);
            statement.setString(4, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật sinh viên thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addClass() {
        String id = classIdField.getText();
        String name = classNameField.getText();
        String teacher = classTeacherField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Lop (MaLop, TenLop, CVHT) VALUES (?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, teacher);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Thêm lớp thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteClass() {
        String id = classIdField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM Lop WHERE MaLop = ?");
            statement.setString(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Xóa lớp thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateClass() {
        String id = classIdField.getText();
        String name = classNameField.getText();
        String teacher = classTeacherField.getText();

        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE Lop SET TenLop = ?, CVHT = ? WHERE MaLop = ?");
            statement.setString(1, name);
            statement.setString(2, teacher);
            statement.setString(3, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật lớp thành công!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void searchStudent() {
        String selectedOption = (String) searchComboBox.getSelectedItem();
        String query = "";
        try {
            if ("Mã SV".equals(selectedOption)) {
                query = "SELECT * FROM SinhVien WHERE MaSV = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, searchField1.getText());
                executeSearch(statement);
            } else if ("Họ tên".equals(selectedOption)) {
                query = "SELECT * FROM SinhVien WHERE HoTen LIKE ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, "%" + searchField1.getText() + "%");
                executeSearch(statement);
            } else if ("Lớp".equals(selectedOption)) {
                query = "SELECT * FROM SinhVien WHERE Lop = ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, searchField1.getText());
                executeSearch(statement);
            } else if ("Điểm TB".equals(selectedOption)) {
                query = "SELECT * FROM SinhVien WHERE DiemTB BETWEEN ? AND ?";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, searchField1.getText());
                statement.setString(2, searchField2.getText());
                executeSearch(statement);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void executeSearch(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        tableModel.setRowCount(0);
        while (resultSet.next()) {
            String id = resultSet.getString("MaSV");
            String name = resultSet.getString("HoTen");
            String className = resultSet.getString("Lop");
            String gpa = resultSet.getString("DiemTB");
            tableModel.addRow(new Object[]{id, name, className, gpa});
        }
    }

    private void sortStudentsByGPA(boolean ascending) {
        String order = ascending ? "ASC" : "DESC";
        String query = "SELECT * FROM SinhVien ORDER BY DiemTB " + order;
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            tableModel.setRowCount(0);
            while (resultSet.next()) {
                String id = resultSet.getString("MaSV");
                String name = resultSet.getString("HoTen");
                String className = resultSet.getString("Lop");
                String gpa = resultSet.getString("DiemTB");
                tableModel.addRow(new Object[]{id, name, className, gpa});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            exercise_05 frame = new exercise_05();
            frame.setVisible(true);
        });
    }
}

