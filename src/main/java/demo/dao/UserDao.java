package demo.dao;

import demo.connector.DatabaseConnector;
import demo.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static demo.model.User.*;

public class UserDao {

    private Statement statement;

    public UserDao() throws SQLException, ClassNotFoundException {
        statement = DatabaseConnector.getConnection().createStatement();
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
        while (rs.next()) {
            users.add(new User(rs.getInt(FIELD_ID), rs.getString(FIELD_FIRST_NAME), rs.getString(FIELD_LAST_NAME)));
        }
        return users;
    }

    public void insert(User user) throws SQLException {
        statement.execute("insert into " + TABLE_NAME + "(" + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + ") values('" +
                user.getFirstName() + "', '" +
                user.getLastName() + "')");
        statement.close();
    }

    public void update(User user) throws SQLException {
        statement.execute("update " + TABLE_NAME + " set " + FIELD_FIRST_NAME + " = '" + user.getFirstName()
                + "', " + FIELD_LAST_NAME + " = '" + user.getLastName() +
                "' where " + FIELD_ID + " = " + user.getId());
    }

}
