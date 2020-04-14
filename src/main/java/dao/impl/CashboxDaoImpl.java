package dao.impl;

import connection.ConnectionPoolException;
import dao.CashboxDAO;
import entity.Cashbox;
import connection.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashboxDaoImpl implements CashboxDAO {
    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Cashbox cashbox = new Cashbox();
    private static final Logger LOGGER =Logger.getLogger(CashboxDaoImpl.class);
    private static final String ADD_QUERY = "insert into cashbox (id_employee, id_client, id_tour, amount, date) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from cashbox";
    private static final String GET_BY_ID_QUERY =  "select * from cashbox where id_client=?";
    private static final String UPDATE_QUERY  = "update cashbox set id_employee = ?, id_client = ?, id_tour = ?, amount = ?, dateset = ?  where id_client=?";
    private static final String REMOVE_QUERY = "delete  from  cashbox where id_client=?";

    private Cashbox setParameterToCashbox(ResultSet resultSet) throws SQLException {
        Cashbox cashbox = new Cashbox();
        cashbox.setIdEmployee(resultSet.getInt("id_employee"));
        cashbox.setIdClient(resultSet.getInt("id_client"));
        cashbox.setIdTour(resultSet.getInt("id_tour"));
        cashbox.setAmount(resultSet.getInt("amount"));
        cashbox.setDate(resultSet.getDate("date"));
        return cashbox;
    }
    @Override
    public void create(Cashbox cashbox) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1,cashbox.getIdEmployee());
            newData.setInt(2,cashbox.getIdClient());
            newData.setInt(3,cashbox.getIdTour());
            newData.setInt(4,cashbox.getAmount());
            newData.setDate(5,cashbox.getDate());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e,e);
        }
    }

    @Override
    public List<Cashbox> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        CashboxDaoImpl cashboxDao = new CashboxDaoImpl();
        List<Cashbox> cashboxes = new ArrayList<>();
        try{
            PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            if(resultSet.next()) {
                cashboxes.add(cashboxDao.setParameterToCashbox(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e,e);
        }
        return cashboxes;
    }

    @Override
    public void update(Cashbox cashbox) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setInt(1,cashbox.getIdEmployee());
            newData.setInt(2,cashbox.getIdClient());
            newData.setInt(3,cashbox.getIdTour());
            newData.setInt(4,cashbox.getAmount());
            newData.setDate(5,cashbox.getDate());
            newData.setInt(8,cashbox.getIdClient());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e,e);
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
            LOGGER.error(e,e);
        }
    }

    @Override
    public List<Cashbox> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Cashbox> cashboxes = new ArrayList<>();
        CashboxDaoImpl cashboxDao = new CashboxDaoImpl();
        try {
            statement = connection.createStatement();
            resultSet= statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                cashboxes.add(cashboxDao.setParameterToCashbox(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e,e);
        }
        return cashboxes;
    }
}
