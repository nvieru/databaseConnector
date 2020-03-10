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
        //se incarca driver-ul pentru sqlite
        Class.forName("org.sqlite.JDBC");
        //se ia calea catre fisierul de sqlite
        String path = DatabaseConnector.class.getClassLoader().getResource(DATABASE).getPath();

        if (connection == null) {
            //se creaza conexiunea catre baza de date
            connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        }
        return connection;
    }

    //inchiderea conexiunii
    public static void closeConnection() throws SQLException {
        if(connection!=null)
            connection.close();
        connection = null;
    }
}
