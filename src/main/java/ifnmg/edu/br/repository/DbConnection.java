package ifnmg.edu.br.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    // Retains the established connection to the database during system operation
    private static Connection connection;

    /**
     * URL database connection
     * (protocol/sgbd/ip/port/database/parameters)
     */
    public static final String URL;

    // Database user
    private static final String USER;

    // Database password
    private static final String PASSWORD;

    // Static initialization
    static {
        // Local server
        URL = "jdbc:mysql://localhost:3306/" + Dao.DB
                + "?useUnicode=true"
                + "&useJDBCCompliantTimezoneShift=true"
                + "&serverTimezone=UTC"
                + "&autoReconnect=true";
        USER = "root";
        PASSWORD = "";
    }

    private DbConnection() {
    }

    /**
     * Establishes and generates database connection retention
     *
     * @return Dabatase connection
     */
    public static Connection getConnection() {
        if (connection == null) {
            try {
                System.out.println(">> New database connection");
                // ... establish and retain the connection
                //     from the provided URL, username and password
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(-1);
            }
        }

        // Returns the established connection
        return connection;
    }
}
