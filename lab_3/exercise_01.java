package lab_3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class exercise_01 extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public exercise_01() {
        setTitle("Quản lý Sinh viên");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the table with a default model
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        loadDataFromDatabase();
    }

    private void loadDataFromDatabase() {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM SinhVien")) {

            // Get metadata to create column names
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }
            tableModel.setColumnIdentifiers(columnNames);

            // Get data
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.add(rs.getObject(i));
                }
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            exercise_01 frame = new exercise_01();
            frame.setVisible(true);
        });
    }
}
