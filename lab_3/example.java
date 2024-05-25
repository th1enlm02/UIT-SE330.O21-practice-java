package jdbc_demo;

/**
 *
 * @author trong
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //String dbURL1="jdbc:ucanaccess://D:\\QLNV.accdb";
            //connection = DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=QLDA;integratedSecurity=true;"); //need to load sqljdbc_auth.dll to sdk's bin folder
            connection = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/qlnhanvien", "...", "...");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM NHANVIEN");
              while(resultSet.next()) {
                System.out.println(resultSet.getString(1)  + "\t"+
                        resultSet.getString(2));
            }
        }
        catch(SQLException sqlex){
            sqlex.printStackTrace();
        }
        finally {
            // Step 3: Closing database connection
            try {
                if(null != connection) { 
                    // cleanup resources, once after processing
                    resultSet.close();
                    statement.close();
                    // and then finally close connection
                    connection.close();
                }
            }
            catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
    }
    
}