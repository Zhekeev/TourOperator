package service;

import dao.ClientDAO;
import entity.Client;
import connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends ConnectionPool implements ClientDAO {
    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Client client = new Client();
    private static final String ADD_QUERY =  "insert into client (first_name, last_name, phone_number, ID_number,date_of_ID) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from client";
    private static final String GET_BY_ID_QUERY = "select * from client where id_client = ";
    private static final String UPDATE_QUERY = "update client set first_name = ?, last_name = ?, phone_number = ?, ID_number = ?, date_of_ID = ?  where id_client= ";
    private static final String REMOVE_QUERY =  "delete  from  client where id_client=";
    ResultSet resultSet = null;
    @Override
    public void addClient(Client client) {
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setString(3,client.getPhoneNumber());
            preparedStatement.setString(4,client.getIdNumber());
            preparedStatement.setDate(5,client.getDateOfId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clientList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Client client = new Client();
                client.setIdClient(resultSet.getInt("id_client"));
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setIdNumber(resultSet.getString("ID_number"));
                client.setDateOfId(resultSet.getDate("date_of_ID"));
                clientList.add(client);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return clientList;
    }

    @Override
    public Client getById(Integer id) throws SQLException {
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()) {
                client.setIdClient(resultSet.getInt("id_client"));
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setPhoneNumber(resultSet.getString("phone_number"));
                client.setIdNumber(resultSet.getString("ID_number"));
                client.setDateOfId(resultSet.getDate("date_of_ID"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void update(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,client.getFirstName());
            preparedStatement.setString(2,client.getLastName());
            preparedStatement.setString(3,client.getPhoneNumber());
            preparedStatement.setString(4,client.getIdNumber());
            preparedStatement.setDate(5,client.getDateOfId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
