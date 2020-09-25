package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.UserDAO;
import entity.User;
import org.apache.log4j.Logger;
import service.HashPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.SqlConstant.*;

public class UserDaoImpl implements UserDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private static final String ADD_QUERY = "insert into user (login, password, first_name, last_name, email, phone_number, address,gender, IIN,date_of_IIN,is_admin) values (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from user";
    private static final String GET_BY_ID_QUERY = "select id ,login,password, first_name, last_name, email,phone_number, address,gender,IIN, date_of_IIN,is_admin  from user where id = ?";
    private static final String GET_CLIENT_BY_NAME = "select id,login,password, first_name, last_name,email, phone_number,address,gender, IIN, date_of_IIN,is_admin from user where first_name like ?";
    private static final String GET_CLIENT_BY_LASTNAME = "select id,login,password, first_name, last_name,email, phone_number,address,gender, IIN, date_of_IIN,is_admin from user where last_name like ?";
    private static final String UPDATE_QUERY = "update user set login =?,password=?,first_name = ?, last_name = ?, email = ?,phone_number = ?,address = ?,gender = ?, IIN = ?, date_of_IIN = ?  where id= ?";
    private static final String UPDATE_BY_ADMIN_QUERY = "update user set login =?,password=?,first_name = ?, last_name = ?, email = ?,phone_number = ?,address = ?,gender = ?, IIN = ?, date_of_IIN = ?,is_admin = ?  where id= ?";
    private static final String REMOVE_QUERY = "delete  from  user where id=?";
    private static final String UPDATE_PASSWORD_QUERY = "update user set password = ? where id = ?";
    private static final String GET_CLIENT_BY_LOGIN_AND_PASSWORD = "select id,login,password,first_name, last_name,email, phone_number,address,gender, IIN, date_of_IIN,is_admin from user where login = ? and password = ?";

    private User setParameterToClient(ResultSet resultSet) throws SQLException {
        User user = new User();
        HashPassword hashPassword = new HashPassword();
        user.setId(resultSet.getInt(ID));
        user.setLogin(resultSet.getString(LOGIN));
        user.setPassword(hashPassword.getHashPassword(resultSet.getString(PASSWORD)));
        user.setFirstName(resultSet.getString(FIRST_NAME));
        user.setLastName(resultSet.getString(LAST_NAME));
        user.setEmail(resultSet.getString(EMAIL));
        user.setPhoneNumber(resultSet.getString(PHONE_NUMBER));
        user.setAddress(resultSet.getString(ADDRESS));
        user.setGender(resultSet.getString(GENDER));
        user.setIIN(resultSet.getString(IIN));
        user.setDateOfIIN(resultSet.getString(DATE_OF_IIN));
        user.setAdmin(resultSet.getBoolean(IS_ADMIN));
        return user;
    }

    @Override
    public void create(User user) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(ADD_QUERY)) {
            newData.setString(1, user.getLogin());
            newData.setString(2, user.getPassword());
            newData.setString(3, user.getFirstName());
            newData.setString(4, user.getLastName());
            newData.setString(5, user.getEmail());
            newData.setString(6, user.getPhoneNumber());
            newData.setString(7, user.getAddress());
            newData.setString(8, user.getGender());
            newData.setString(9, user.getIIN());
            newData.setString(10, user.getDateOfIIN());
            newData.setBoolean(11, user.getAdmin());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public List<User> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<User> users = new ArrayList<>();
        UserDaoImpl clientDao = new UserDaoImpl();
        try (PreparedStatement newData = connection.prepareStatement(GET_ALL_QUERY)) {
            resultSet = newData.executeQuery();
            while (resultSet.next()) {
                users.add(clientDao.setParameterToClient(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return users;
    }

    @Override
    public User getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        User user = null;
        try (PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY)) {
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt(ID));
                user.setLogin(resultSet.getNString(LOGIN));
                user.setPassword(resultSet.getNString(PASSWORD));
                user.setFirstName(resultSet.getNString(FIRST_NAME));
                user.setLastName(resultSet.getNString(LAST_NAME));
                user.setEmail(resultSet.getNString(EMAIL));
                user.setPhoneNumber(resultSet.getNString(PHONE_NUMBER));
                user.setAddress(resultSet.getNString(ADDRESS));
                user.setGender(resultSet.getNString(GENDER));
                user.setIIN(resultSet.getNString(IIN));
                user.setDateOfIIN(resultSet.getNString(DATE_OF_IIN));
                user.setAdmin(resultSet.getBoolean(IS_ADMIN));
                return user;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public List<User> getClientByName(String name) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        UserDaoImpl clientDao = new UserDaoImpl();
        List<User> users = new ArrayList<>();
        try (PreparedStatement newData = connection.prepareStatement(GET_CLIENT_BY_NAME)) {
            newData.setString(1, "%" + name + "%");
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()) {
                users.add(clientDao.setParameterToClient(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return users;
    }

    @Override
    public List<User> getClientByLastName(String name) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        UserDaoImpl clientDao = new UserDaoImpl();
        List<User> users = new ArrayList<>();
        try (PreparedStatement newData = connection.prepareStatement(GET_CLIENT_BY_LASTNAME)) {
            newData.setString(1, "%" + name + "%");
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()) {
                users.add(clientDao.setParameterToClient(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return users;
    }

    public User getClientByLoginAndPassword(String login, String password) throws ConnectionPoolException {
        User user = null;
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(GET_CLIENT_BY_LOGIN_AND_PASSWORD)) {
            newData.setString(1, login);
            newData.setString(2, password);
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt(ID));
                user.setLogin(resultSet.getNString(LOGIN));
                user.setPassword(resultSet.getNString(PASSWORD));
                user.setFirstName(resultSet.getNString(FIRST_NAME));
                user.setLastName(resultSet.getNString(LAST_NAME));
                user.setEmail(resultSet.getNString(EMAIL));
                user.setPhoneNumber(resultSet.getNString(PHONE_NUMBER));
                user.setAddress(resultSet.getNString(ADDRESS));
                user.setGender(resultSet.getNString(GENDER));
                user.setIIN(resultSet.getNString(IIN));
                user.setDateOfIIN(resultSet.getNString(DATE_OF_IIN));
                user.setAdmin(resultSet.getBoolean(IS_ADMIN));
                return user;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return user;
    }

    @Override
    public void update(int id, User user) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY)) {
            newData.setString(1, user.getLogin());
            newData.setString(2, user.getPassword());
            newData.setString(3, user.getFirstName());
            newData.setString(4, user.getLastName());
            newData.setString(5, user.getEmail());
            newData.setString(6, user.getPhoneNumber());
            newData.setString(7, user.getAddress());
            newData.setString(8, user.getGender());
            newData.setString(9, user.getIIN());
            newData.setString(10, user.getDateOfIIN());
            newData.setInt(11, id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    public void updateByAdmin(int id, User user) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(UPDATE_BY_ADMIN_QUERY)) {
            newData.setString(1, user.getLogin());
            newData.setString(2, user.getPassword());
            newData.setString(3, user.getFirstName());
            newData.setString(4, user.getLastName());
            newData.setString(5, user.getEmail());
            newData.setString(6, user.getPhoneNumber());
            newData.setString(7, user.getAddress());
            newData.setString(8, user.getGender());
            newData.setString(9, user.getIIN());
            newData.setString(10, user.getDateOfIIN());
            newData.setBoolean(11,user.getAdmin());
            newData.setInt(12, id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updatePassword(int id, User user) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_PASSWORD_QUERY);
            newData.setString(1, user.getPassword());
            newData.setInt(2, id);
            newData.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(REMOVE_QUERY);
            newData.setInt(1, id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
