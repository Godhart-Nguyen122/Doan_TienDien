package Controller;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBS {
        public static Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionURL = "jdbc:sqlserver://localhost:1433;databaseName=TmpTienDien1;encrypt=false;";
        String username = "sa";
        String password = "123456";
        //12345
        Connection con = DriverManager.getConnection(connectionURL, username, password);
        return con;
    }
}
