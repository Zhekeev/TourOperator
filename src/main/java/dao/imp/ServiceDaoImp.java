package dao.imp;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ServiceDAO;
import entity.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImp implements ServiceDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Service service = new Service();
    private static final String ADD_QUERY =  "insert into service (name, id_language) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from service";
    private static final String GET_BY_ID_QUERY = "select * from service where id_service = ";
    private static final String UPDATE_QUERY = "update service set name = ?, id_language where id_service = ";
    private static final String REMOVE_QUERY =  "delete from service where id_service = ";

    @Override
    public void create(Service object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getIdLanguage());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Service getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                service.setId(resultSet.getInt("id_service"));
                service.setName(resultSet.getString("name"));
                service.setIdLanguage(resultSet.getInt("id_language"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public void update(int id, Service object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setInt(2,service.getIdLanguage());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Service> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Service> serviceList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Service service = new Service();
                service.setId(resultSet.getInt("id_service"));
                service.setName(resultSet.getString("name"));
                service.setIdLanguage(resultSet.getInt("id_language"));
                serviceList.add(service);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }
}
