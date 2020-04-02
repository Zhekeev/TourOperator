package dao.impl;

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
    private static final String ADD_QUERY =  "insert into service (name, description, price) values (?,?,?)";
    private static final String GET_ALL_QUERY = "select * from service";
    private static final String GET_BY_ID_QUERY = "select * from service where id_service = ";
    private static final String UPDATE_QUERY = "update service set name = ?, description = ?, price = ? where id_service = ";
    private static final String REMOVE_QUERY =  "delete from service where id_service = ";

    private void setParameterToService(Service service,ResultSet resultSet) throws SQLException {
        service.setId(resultSet.getInt("id_service"));
        service.setName(resultSet.getString("name"));
        service.setDescription(resultSet.getString("description"));
        service.setPrice(resultSet.getBigDecimal("price"));
    }
    @Override
    public void create(Service service) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setString(2,service.getDescription());
            preparedStatement.setBigDecimal(3,service.getPrice());
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
                setParameterToService(service,resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public void update(int id, Service service) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setString(2,service.getDescription());
            preparedStatement.setBigDecimal(3,service.getPrice());
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
                setParameterToService(service,resultSet);
                serviceList.add(service);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceList;
    }
}
