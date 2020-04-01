package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ServiceContractDAO;
import entity.ServiceContract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceContractDaoImp implements ServiceContractDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private ServiceContract serviceContract = new ServiceContract();
    private static final String ADD_QUERY =  "insert into service_contract (id_contract, id_service) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from service_contract";
    private static final String GET_BY_ID_QUERY = "select * from service_contract where id_contract = ";
    private static final String UPDATE_QUERY = "update service_contract set id_service = ? where id_contract = ";
    private static final String REMOVE_QUERY =  "delete from service_contract where id_contract = ";

    @Override
    public void create(ServiceContract object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setInt(1,serviceContract.getIdContract());
            preparedStatement.setInt(2,serviceContract.getIdService());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public ServiceContract getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                serviceContract.setIdContract(resultSet.getInt("id_contract"));
                serviceContract.setIdService(resultSet.getInt("id_service"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceContract;
    }

    @Override
    public void update(int id, ServiceContract object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setInt(1,serviceContract.getIdService());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
    public List<ServiceContract> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<ServiceContract> serviceContractList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                ServiceContract serviceContract = new ServiceContract();
                serviceContract.setIdContract(resultSet.getInt("id_contract"));
                serviceContract.setIdService(resultSet.getInt("id_service"));
                serviceContractList.add(serviceContract);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return serviceContractList;
    }
}
