package dao.impl;

import connection.ConnectionPoolException;
import dao.CashboxDAO;
import entity.Cashbox;
import connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashboxDaoImp implements CashboxDAO {
    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Cashbox cashbox = new Cashbox();
    private static final String ADD_QUERY = "insert into cashbox (id_employee, id_client, id_tour, amount, date) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from cashbox";
    private static final String GET_BY_ID_QUERY =  "select * from cashbox where id_client=";
    private static final String UPDATE_QUERY  = "update cashbox set id_employee = ?, id_client = ?, id_tour = ?, amount = ?, dateset = ?  where id_client=";
    private static final String REMOVE_QUERY = "delete  from  cashbox where id_client=";

    @Override
    public void create(Cashbox object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setInt(1,cashbox.getIdEmployee());
            preparedStatement.setInt(2,cashbox.getIdClient());
            preparedStatement.setInt(3,cashbox.getIdTour());
            preparedStatement.setInt(4,cashbox.getAmount());
            preparedStatement.setDate(5,cashbox.getDate());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Cashbox getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try{
            statement = connection.createStatement();
            Cashbox cashbox = new Cashbox();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()) {
                cashbox.setIdEmployee(resultSet.getInt("id_employee"));
                cashbox.setIdClient(resultSet.getInt("id_client"));
                cashbox.setIdTour(resultSet.getInt("id_tour"));
                cashbox.setAmount(resultSet.getInt("amount"));
                cashbox.setDate(resultSet.getDate("date"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashbox;
    }

    @Override
    public void update(int id, Cashbox object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setInt(1,cashbox.getIdEmployee());
            preparedStatement.setInt(2,cashbox.getIdClient());
            preparedStatement.setInt(3,cashbox.getIdTour());
            preparedStatement.setInt(4,cashbox.getAmount());
            preparedStatement.setDate(5,cashbox.getDate());
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
            preparedStatement.setInt(1, cashbox.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cashbox> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Cashbox> cashboxList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Cashbox cashbox = new Cashbox();
                cashbox.setIdEmployee(resultSet.getInt("id_employee"));
                cashbox.setIdClient(resultSet.getInt("id_client"));
                cashbox.setIdTour(resultSet.getInt("id_tour"));
                cashbox.setAmount(resultSet.getInt("amount"));
                cashbox.setDate(resultSet.getDate("date"));
                cashboxList.add(cashbox);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashboxList;
    }
}
