package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ServiceDAO;
import entity.Service;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceDaoImpl implements ServiceDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(ServiceDaoImpl.class);
    private static final String ADD_QUERY =  "insert into service (name, description, price) values (?,?,?)";
    private static final String GET_ALL_QUERY = "select * from service";
    private static final String GET_ALL_QUERY_BY_ID = "select * from service where id = ?";
    private static final String GET_BY_ID_QUERY = "select id, name, description, price from service where id = ?";
    private static final String UPDATE_QUERY = "update service set name = ?, description = ?, price = ? where id = ?";
    private static final String REMOVE_QUERY =  "delete from service where id = ?";

    private Service setParameterToService(ResultSet resultSet) throws SQLException {
        Service service = new Service();
        service.setId(resultSet.getInt("id"));
        service.setName(resultSet.getString("name"));
        service.setDescription(resultSet.getString("description"));
        service.setPrice(resultSet.getBigDecimal("price"));
        return service;
    }

    @Override
    public void create(Service service) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,service.getName());
            newData.setString(2,service.getDescription());
            newData.setBigDecimal(3,service.getPrice());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Service> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Service> services = new ArrayList<>();
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                services.add(serviceDao.setParameterToService(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return services;
    }

    public List<Service> getAllbyId(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Service> services = new ArrayList<>();
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY_BY_ID);
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                services.add(serviceDao.setParameterToService(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return services;
    }

    @Override
    public Service getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        Service service = null;
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                service = setParameterToService(resultSet);
                return service;
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return service;
    }

    @Override
    public void update(int id,Service service) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,service.getName());
            newData.setString(2,service.getDescription());
            newData.setBigDecimal(3,service.getPrice());
            newData.setInt(4,id);
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(REMOVE_QUERY);
            newData.setInt(1,id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
