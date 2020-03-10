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
        //se creaza un statement(un utilitar care se foloseste pentru comunicarea cu baza de date)
        statement = DatabaseConnector.getConnection().createStatement();
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<User>();
        //se executa query-ul
        //ResultSet rs = statement.executeQuery("select * from users"); <-- ar fi avut acelasi rezultat ca si mai jos
        ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
        //va fi returnat un set de rezultate
        while (rs.next()) {
            //fiecare vom lua valorile din set dupa numele coloanei
            //aici am vrut sa evidentiez ca trebuie sa avem un constructor sau niste setter pentru a mapa rezultatul pe un obiect java
            users.add(new User(rs.getInt(FIELD_ID), rs.getString(FIELD_FIRST_NAME), rs.getString(FIELD_LAST_NAME)));
        }
        return users;
    }

    public void insert(User user) throws SQLException {
        //am executat un insert in baza de date
        //se poate face si un insert static dupa cum urmeaza
        //statement.execute("insert into users(first_name, last_name) values('Ion','Vasile');
        //am vrut sa arat cat de verbose poate fi o simpla operatie de insert
        statement.execute("insert into " + TABLE_NAME + "(" + FIELD_FIRST_NAME + ", " + FIELD_LAST_NAME + ") values('" +
                user.getFirstName() + "', '" +
                user.getLastName() + "')");
        statement.close();
    }

    //acelasi lucru ca si la insert
    public void update(User user) throws SQLException {
        statement.execute("update " + TABLE_NAME + " set " + FIELD_FIRST_NAME + " = '" + user.getFirstName()
                + "', " + FIELD_LAST_NAME + " = '" + user.getLastName() +
                "' where " + FIELD_ID + " = " + user.getId());
    }

}
