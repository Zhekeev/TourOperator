import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws ConnectionPoolException {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.getClientByName("Timofey");
        for (User u: users) {
            System.out.println(u);
        }
    }
}
