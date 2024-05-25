package lab_3;

import java.sql.*;

public class exercise_02 {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLSV;integratedSecurity=true;encrypt=true;trustServerCertificate=true";

        try (Connection conn = DriverManager.getConnection(connectionUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name FROM sys.tables")) {

            System.out.println("Các bảng trong cơ sở dữ liệu:");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}