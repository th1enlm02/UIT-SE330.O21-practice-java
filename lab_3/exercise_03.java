package lab_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class exercise_03 extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel studentPanel, classPanel;
    private JButton addStudentButton, deleteStudentButton, updateStudentButton;
    private JButton addClassButton, deleteClassButton, updateClassButton;
    private JTextField studentIdField, studentNameField, studentClassField, studentGPAField;
    private JTextField classIdField, classNameField, classTeacherField;
    private Connection conn;

    public exercise_03() {
        setTitle("Quản lý Sinh viên và Lớp học");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();

        // Panel Sinh Viên
        studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(5, 2));
        addStudentButton = new JButton("Thêm Sinh Viên");
        deleteStudentButton = new JButton("Xóa Sinh Viên");
        updateStudentButton = new JButton("Cập nhật Sinh Viên");
        studentIdField = new JTextField();
        studentNameField = new JTextField();
        studentClassField = new JTextField();
        studentGPAField = new JTextField();
        studentPanel.add(new JLabel("Mã SV:"));
        studentPanel.add(studentIdField);
        studentPanel.add(new JLabel("Họ Tên:"));
        studentPanel.add(studentNameField);
        studentPanel.add(new JLabel("Lớp:"));
        studentPanel.add(studentClassField);
        studentPanel.add(new JLabel("Điểm TB:"));
        studentPanel.add(studentGPAField);
        studentPanel.add(addStudentButton);
        studentPanel.add(deleteStudentButton);
        studentPanel.add(updateStudentButton);

        // Panel Lớp
        classPanel = new JPanel();
        classPanel.setLayout(new GridLayout(4, 2));
        addClassButton = new JButton("Thêm Lớp");
        deleteClassButton = new JButton("Xóa Lớp");
        updateClassButton = new JButton("Cập nhật Lớp");
        classIdField = new JTextField();
        classNameField = new JTextField();
        classTeacherField = new JTextField();
        classPanel.add(new JLabel("Mã Lớp:"));
        classPanel.add(classIdField);
        classPanel.add(new JLabel("Tên Lớp:"));
        classPanel.add(classNameField);
        classPanel.add(new JLabel("CVHT:"));
        classPanel.add(classTeacherField);
        classPanel.add(addClassButton);
        classPanel.add(deleteClassButton);
        classPanel.add(updateClassButton);

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
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            exercise_03 frame = new exercise_03();
            frame.setVisible(true);
        });
    }
}