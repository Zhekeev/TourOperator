package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ContractDAO;
import entity.Contract;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImpl implements ContractDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet;
    private static final Logger LOGGER = Logger.getLogger(ContractDaoImpl.class);
    private static final String ADD_QUERY = "insert into contract (id_client, id_employee, id_tour, tour_start_date, tour_finish_date) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from contract";
    private static final String GET_BY_ID_QUERY = "select id_contract,id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ? from contract where id_contract= ?";
    private static final String UPDATE_QUERY = "update conctract set id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ?  where id_contract=?";
    private static final String REMOVE_QUERY = "delete  from  contract where id_client=?";

    private Contract setParameterToContract(ResultSet resultSet) throws SQLException {
        Contract contract = new Contract();
        contract.setId(resultSet.getInt("id_contract"));
        contract.setIdClient(resultSet.getInt("id_client"));
        contract.setIdEmployee(resultSet.getInt("id_employee"));
        contract.setIdTour(resultSet.getInt("id_tour"));
        contract.setTourStartDate(resultSet.getDate("tour_start_date"));
        contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
        return contract;
    }

    @Override
    public void create(Contract contract) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1, contract.getIdClient());
            newData.setInt(2, contract.getIdEmployee());
            newData.setInt(3, contract.getIdTour());
            newData.setDate(4, contract.getTourStartDate());
            newData.setDate(5, contract.getTourFinishDate());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e ,e);
        }
    }


    @Override
    public List<Contract> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        ContractDaoImpl contractDao = new ContractDaoImpl();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                contracts.add(contractDao.setParameterToContract(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e ,e);
        }
        return contracts;
    }

        @Override
        public List<Contract> getAll () throws ConnectionPoolException {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            List<Contract> contracts = new ArrayList<>();
            ContractDaoImpl contractDao = new ContractDaoImpl();
            try {
                PreparedStatement newData = connection.prepareStatement(GET_ALL_QUERY);
                resultSet = newData.executeQuery();
                while (resultSet.next()) {
                    contracts.add(contractDao.setParameterToContract(resultSet));
                }
            } catch (SQLException e) {
                LOGGER.error(e ,e);
            }
            return contracts;
        }

    @Override
    public void update(Contract contract) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setInt(1, contract.getIdClient());
            newData.setInt(2, contract.getIdEmployee());
            newData.setInt(3, contract.getIdTour());
            newData.setDate(4, contract.getTourStartDate());
            newData.setDate(5, contract.getTourFinishDate());
            newData.setInt(6,contract.getId());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e ,e);
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
            LOGGER.error(e ,e);
        }
    }
}

