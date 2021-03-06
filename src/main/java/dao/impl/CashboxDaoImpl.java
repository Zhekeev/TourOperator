package dao.impl;

import connection.ConnectionPoolException;
import dao.CashboxDAO;
import entity.Cashbox;
import connection.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constant.SqlConstant.*;

public class CashboxDaoImpl implements CashboxDAO {
    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Cashbox cashbox = new Cashbox();
    private static final Logger LOGGER =Logger.getLogger(CashboxDaoImpl.class);
    private static final String ADD_QUERY = "insert into cashbox (id_client, id_tour, amount, date_current) values (?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from cashbox";
    private static final String GET_BY_ID_QUERY =  "select * from cashbox where id_client=?";
    private static final String UPDATE_QUERY  = "update cashbox set id_client = ?, id_tour = ?, amount = ?, date_current = ?  where id_client=?";
    private static final String REMOVE_QUERY = "delete  from  cashbox where id_client=?";

    private Cashbox setParameterToCashbox(ResultSet resultSet) throws SQLException {
        Cashbox cashbox = new Cashbox();
        cashbox.setIdClient(resultSet.getInt(ID_CLIENT));
        cashbox.setIdTour(resultSet.getInt(ID_TOUR));
        cashbox.setAmount(resultSet.getBigDecimal(AMOUNT));
        cashbox.setDate(resultSet.getString(DATE));
        return cashbox;
    }
    @Override
    public void create(Cashbox cashbox) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1,cashbox.getIdClient());
            newData.setInt(2,cashbox.getIdTour());
            newData.setBigDecimal(3,cashbox.getAmount());
            newData.setString(4,cashbox.getDate());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e,e);
        }
    }

    @Override
    public Cashbox getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        CashboxDaoImpl cashboxDao = new CashboxDaoImpl();
        List<Cashbox> cashboxes = new ArrayList<>();
        Cashbox cashbox = null;
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
        return cashbox;
    }

    @Override
    public void update(int id, Cashbox cashbox) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY)) {
            newData.setInt(1,cashbox.getIdClient());
            newData.setInt(2,cashbox.getIdTour());
            newData.setBigDecimal(3,cashbox.getAmount());
            newData.setString(4,cashbox.getDate());
            newData.setInt(5,id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(REMOVE_QUERY)){
            newData.setInt(1, id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
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
