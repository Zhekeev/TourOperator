package dao.impl;

import connection.ConnectionPoolException;
import dao.ClientDAO;
import entity.Client;
import connection.ConnectionPool;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(ClientDaoImpl.class);
    private static final String ADD_QUERY =  "insert into client (login,password,first_name, last_name, phone_number, ID_number,date_of_ID) values (?,?,?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from client";
    private static final String GET_BY_ID_QUERY = "select id_client , first_name, last_name, phone_number, ID_number, date_of_ID  from client where id_client = ?";
    private static final String GET_CLIENT_BY_NAME = "select id_client, first_name, last_name, phone_number, ID_number, date_of_ID from client where first_name like ?";
    private static final String GET_CLIENT_BY_LASTNAME = "select id_client, first_name, last_name, phone_number, ID_number, date_of_ID from client where first_name like ?";
    private static final String UPDATE_QUERY = "update client set login =?,password=?,first_name = ?, last_name = ?, phone_number = ?, ID_number = ?, date_of_ID = ?  where id_client= ?";
    private static final String REMOVE_QUERY =  "delete  from  client where id_client=?";
    private static final String UPDATE_PASSWORD_QUERY = "update client set password = ? where login = ?";

    private Client setParameterToClient(ResultSet resultSet) throws SQLException{
        Client client = new Client();
        client.setId(resultSet.getInt("id_client"));
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setPhoneNumber(resultSet.getString("phone_number"));
        client.setIdNumber(resultSet.getString("ID_number"));
        client.setDateOfId(resultSet.getDate("date_of_ID"));
        return client;
    }

    @Override
    public void create(Client client) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,client.getLogin());
            newData.setString(2,client.getPassword());
            newData.setString(3,client.getFirstName());
            newData.setString(4,client.getLastName());
            newData.setString(5,client.getPhoneNumber());
            newData.setString(6,client.getIdNumber());
            newData.setDate(7,client.getDateOfId());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Client> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Client> clients = new ArrayList<>();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                clients.add(clientDao.setParameterToClient(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return clients;
    }

    @Override
    public List<Client> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List <Client> clientList =new ArrayList<>();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        try{
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()) {
                clientList.add(clientDao.setParameterToClient(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return clientList;
    }

    @Override
    public List<Client> getClientByName(String name) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_CLIENT_BY_NAME);
            newData.setString(1,"%" + name + "%");
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()){
                clients.add(clientDao.setParameterToClient(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return clients;
    }

    @Override
    public List<Client> getClientByLastName(String name) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        ClientDaoImpl clientDao = new ClientDaoImpl();
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_CLIENT_BY_LASTNAME);
            newData.setString(1,"%"+name+"%");
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()){
                clients.add(clientDao.setParameterToClient(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return clients;
    }

    @Override
    public void update(Client client) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY );
            newData.setString(1,client.getLogin());
            newData.setString(2,client.getPassword());
            newData.setString(3,client.getFirstName());
            newData.setString(4,client.getLastName());
            newData.setString(5,client.getPhoneNumber());
            newData.setString(6,client.getIdNumber());
            newData.setDate(7,client.getDateOfId());
            newData.setInt(8,client.getId());
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void updatePassword(Client client) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_PASSWORD_QUERY);
            newData.setString(1,client.getPassword());
            newData.setString(2,client.getLogin());
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
