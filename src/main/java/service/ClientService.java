package service;

import dao.ClientDAO;
import entity.Cashbox;
import entity.Client;
import logic.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends Util implements ClientDAO {
    Connection connection = getConnection();

    @Override
    public void add(Client client) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into client (first_name, last_name, phone_number, ID_number,date_of_ID) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2,client.getFirstName());
            preparedStatement.setString(3,client.getLastName());
            preparedStatement.setInt(4,client.getPhoneNumber());
            preparedStatement.setString(5,client.getIdNumber());
            preparedStatement.setDate(6,client.getDateOfId());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Client> getAll() {
        List<Client> clientList = new ArrayList<>();
        String sql = "select * from client";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Client client = new Client();
                client.setFirstName(resultSet.getString("first_name"));
                client.setLastName(resultSet.getString("last_name"));
                client.setPhoneNumber(resultSet.getInt("phone_number"));
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
        PreparedStatement preparedStatement = null;
        String sql = "select * from client where id_client=?";
        Client client = new Client();
        ResultSet resultSet = preparedStatement.executeQuery();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            client.setFirstName(resultSet.getString("first_name"));
            client.setLastName(resultSet.getString("last_mame"));
            client.setPhoneNumber(resultSet.getInt("phone_number"));
            client.setIdNumber(resultSet.getString("ID_number"));
            client.setDateOfId(resultSet.getDate("date_of_ID"));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public void update(Client client) {
        PreparedStatement preparedStatement = null;

        String sql = "update client set first_name = ?, last_name = ?, phone_number = ?, ID_number = ?, date_of_ID = ?  where id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(2,client.getFirstName());
            preparedStatement.setString(3,client.getLastName());
            preparedStatement.setInt(4,client.getPhoneNumber());
            preparedStatement.setString(5,client.getIdNumber());
            preparedStatement.setDate(6,client.getDateOfId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Client client) {
        PreparedStatement preparedStatement = null;
        String sql = "delete  from  client where id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(5, client.getIdNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
