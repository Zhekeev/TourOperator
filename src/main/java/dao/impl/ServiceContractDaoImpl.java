package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ServiceContractDAO;
import entity.ServiceContract;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceContractDaoImpl implements ServiceContractDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(ServiceContractDaoImpl.class);
    private static final String ADD_QUERY =  "insert into service_contract (id_contract, id_service) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from service_contract";
    private static final String GET_BY_ID_QUERY = "select id_service from service_contract where id_contract = ?";
    private static final String UPDATE_QUERY = "update service_contract set id_service = ? where id_contract = ?";
    private static final String REMOVE_QUERY =  "delete from service_contract where id_contract = ?";

    private ServiceContract setParameterToServiceContract(ResultSet resultSet) throws SQLException {
        ServiceContract serviceContract = new ServiceContract();
        serviceContract.setIdContract(resultSet.getInt("id_contract"));
        serviceContract.setIdService(resultSet.getInt("id_service"));
        return serviceContract;
    }

    @Override
    public void create(ServiceContract serviceContract) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1,serviceContract.getIdContract());
            newData.setInt(2,serviceContract.getIdService());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<ServiceContract> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        ServiceContractDaoImpl serviceContractDao = new ServiceContractDaoImpl();
        List<ServiceContract> serviceContracts = new ArrayList<>();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                serviceContracts.add(serviceContractDao.setParameterToServiceContract(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return serviceContracts;
    }

    @Override
    public ServiceContract getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        ServiceContractDaoImpl serviceContractDao = new ServiceContractDaoImpl();
        List<ServiceContract> serviceContracts = new ArrayList<>();
        ServiceContract serviceContract = null;
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                serviceContracts.add(serviceContractDao.setParameterToServiceContract(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return serviceContract;
    }

    @Override
    public void update(int id,ServiceContract serviceContract) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setInt(1,serviceContract.getIdService());
            newData.setInt(2,serviceContract.getIdContract());
            newData.executeUpdate();
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
            newData.setInt(1,id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
