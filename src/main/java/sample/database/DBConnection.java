package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * DB Connection class
 */
public class DBConnection {


    // Connection conn
    public Connection con;


    // Get connection
    public Connection geConnection() {
        // Database URL : MySQL - Detection
        String url = "jdbc:mysql://localhost:3306/detection";
        try {
            con = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}





// Thu loi - toan nghe nhac -