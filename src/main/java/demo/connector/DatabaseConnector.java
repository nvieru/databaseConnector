package demo.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static final String DATABASE = "db1.db";
    public static Connection connection;

    private DatabaseConnector() {
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String path = DatabaseConnector.class.getClassLoader().getResource(DATABASE).getPath();

        if (connection == null) {
            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if(connection!=null)
            connection.close();
        connection = null;
    }
}
