package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ContractDAO;
import entity.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDaoImp implements ContractDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet;
    private Contract contract = new Contract();
    private static final String ADD_QUERY = "insert into contract (id_client, id_employee, id_tour, tour_start_date, tour_finish_date) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from contract";
    private static final String GET_BY_ID_QUERY = "select * from contract where id_contract= ";
    private static final String UPDATE_QUERY = "update conctract set id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ?  where id_contract=?";
    private static final String REMOVE_QUERY = "delete  from  contract where id_client=?";

    private void setParameterToContract(Contract contract, ResultSet resultSet) throws SQLException {
        contract.setIdClient(resultSet.getInt("id_client"));
        contract.setIdEmployee(resultSet.getInt("id_employee"));
        contract.setIdTour(resultSet.getInt("id_tour"));
        contract.setTourStartDate(resultSet.getDate("tour_start_date"));
        contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
    }

    @Override
    public void create(Contract object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setInt(1, contract.getIdClient());
            preparedStatement.setInt(2, contract.getIdEmployee());
            preparedStatement.setInt(3, contract.getIdTour());
            preparedStatement.setDate(4, contract.getTourStartDate());
            preparedStatement.setDate(5, contract.getTourFinishDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Contract getByID(int id) throws SQLException, ConnectionPoolException {
        {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
                setParameterToContract(contract, resultSet);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return contract;
        }
    }

        @Override
        public List<Contract> getAll () throws SQLException, ConnectionPoolException {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            List<Contract> contractList = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
                while (resultSet.next()) {
                    Contract contract = new Contract();
                    setParameterToContract(contract, resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return contractList;
        }

    @Override
    public void update(int id, Contract object) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setInt(1, contract.getIdClient());
            preparedStatement.setInt(2, contract.getIdEmployee());
            preparedStatement.setInt(3, contract.getIdTour());
            preparedStatement.setDate(4, contract.getTourStartDate());
            preparedStatement.setDate(5, contract.getTourFinishDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.setInt(1, contract.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

