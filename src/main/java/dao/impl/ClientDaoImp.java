package dao.impl;

import connection.ConnectionPoolException;
import dao.ClientDAO;
import entity.Client;
import connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements ClientDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Client client = new Client();
    private static final String ADD_QUERY =  "insert into client (login,password,first_name, last_name, phone_number, ID_number,date_of_ID) values (?,?,?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from client";
    private static final String GET_BY_ID_QUERY = "select * from client where id_client = ";
    private static final String UPDATE_QUERY = "update client set login =?,password=?,first_name = ?, last_name = ?, phone_number = ?, ID_number = ?, date_of_ID = ?  where id_client= ";
    private static final String REMOVE_QUERY =  "delete  from  client where id_client=";

    private void setParameterToClient(Client client, ResultSet resultSet) throws SQLException{
        client.setIdClient(resultSet.getInt("id_client"));
        client.setLogin(resultSet.getString("login"));
        client.setPassword(resultSet.getString("password"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setPhoneNumber(resultSet.getString("phone_number"));
        client.setIdNumber(resultSet.getString("ID_number"));
        client.setDateOfId(resultSet.getDate("date_of_ID"));
    }

    @Override
    public void create(Client client) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,client.getLogin());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.setString(3,client.getFirstName());
            preparedStatement.setString(4,client.getLastName());
            preparedStatement.setString(5,client.getPhoneNumber());
            preparedStatement.setString(6,client.getIdNumber());
            preparedStatement.setDate(7,client.getDateOfId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Client> clientList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Client client = new Client();
                setParameterToClient(client, resultSet);
                clientList.add(client);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()) {
                setParameterToClient(client,resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void update(int id, Client client) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,client.getLogin());
            preparedStatement.setString(2,client.getPassword());
            preparedStatement.setString(3,client.getFirstName());
            preparedStatement.setString(4,client.getLastName());
            preparedStatement.setString(5,client.getPhoneNumber());
            preparedStatement.setString(6,client.getIdNumber());
            preparedStatement.setDate(7,client.getDateOfId());
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
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
