import demo.connector.DatabaseConnector;
import demo.dao.UserDao;
import demo.model.User;

import java.sql.SQLException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        printUsers(userDao);
        System.out.println("--------insert");
        userDao.insert(new User("Test","Test"));
        System.out.println("-----------select");
        printUsers(userDao);
        System.out.println("--------update");
        userDao.update(new User(3,"TestUpdate" +3,"TestUpdate" + 3));
        System.out.println("-----------select");
        printUsers(userDao);

        DatabaseConnector.closeConnection();
    }

    private static void printUsers(UserDao userDao) throws SQLException {
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }


}
