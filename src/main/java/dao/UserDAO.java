package dao;

import connection.ConnectionPoolException;
import entity.User;

import java.util.List;

public interface UserDAO extends BaseDAO<User>{
    void updatePassword(int id, User user) throws ConnectionPoolException;
    List<User> getClientByName(String name) throws ConnectionPoolException;
    List<User> getClientByLastName(String name) throws ConnectionPoolException;
}
