package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ContractDAO;
import entity.Contract;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImpl implements ContractDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet;
    private static final Logger LOGGER = Logger.getLogger(ContractDaoImpl.class);
    private static final String ADD_QUERY = "insert into contract (id_client, id_tour, tour_start_date, tour_finish_date) values (?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from contract";
    private static final String GET_BY_ID_QUERY = "select id_contract,id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ? from contract where id_contract= ?";
    private static final String UPDATE_QUERY = "update conctract set id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ?  where id_contract=?";
    private static final String REMOVE_QUERY = "delete  from  contract where id_client=?";
    private static final String GET_INFO_ABOUT_CONTRACT = "select user.first_name as name, tour.name_ru as tour_name, contract.tour_start_date, contract.tour_finish_date from\n" +
            "user join contract on user.id = contract.id_client\n" +
            "join tour on tour.id = contract.id_tour where user.id = ?";

    private Contract setParameterToContract(ResultSet resultSet) throws SQLException {
        Contract contract = new Contract();
        contract.setId(resultSet.getInt("id_contract"));
        contract.setIdClient(resultSet.getInt("id_client"));
        contract.setIdTour(resultSet.getInt("id_tour"));
        contract.setTourStartDate(resultSet.getDate("tour_start_date"));
        contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
        return contract;
    }

    @Override
    public void create(Contract contract) throws ConnectionPoolException, ParseException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1, contract.getIdClient());
            newData.setInt(2, contract.getIdTour());
            newData.setDate(3,contract.getTourStartDate());
            newData.setDate(4,contract.getTourFinishDate());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
    }


    @Override
    public Contract getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        Contract contract = null;
        ContractDaoImpl contractDao = new ContractDaoImpl();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if (resultSet.next()) {
                contracts.add(contractDao.setParameterToContract(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
        return contract;
    }

    public Contract getInfoById(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        Contract contract = null;
        ContractDaoImpl contractDao = new ContractDaoImpl();
        List<Contract> contracts = new ArrayList<>();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_INFO_ABOUT_CONTRACT);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if (resultSet.next()) {
                contracts.add(contractDao.setParameterToContract(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e, e);
        }
        return contract;
    }

    @Override
    public List<Contract> getAll() throws ConnectionPoolException {
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
            LOGGER.error(e, e);
        }
        return contracts;
    }

    @Override
    public void update(int id, Contract contract) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setInt(1, contract.getIdClient());
            newData.setInt(3, contract.getIdTour());
            newData.setDate(4, contract.getTourStartDate());
            newData.setDate(5, contract.getTourFinishDate());
            newData.setInt(6, contract.getId());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e, e);
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
            LOGGER.error(e, e);
        }
    }
}

