package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.CountryDAO;
import entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImp implements CountryDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Country country = new Country();
    private static final String ADD_QUERY =  "insert into country (id_country, name, id_language, id_image) values (?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from country";
    private static final String GET_BY_ID_QUERY = "select * from country where id_country = ";
    private static final String UPDATE_QUERY = "update country set name = ?, id_language = ?, id_image = ?, where id_country= ";
    private static final String REMOVE_QUERY =  "delete  from  country where id_country=";

    private void setParameterToCountry(Country country, ResultSet resultSet) throws SQLException {
        country.setName(resultSet.getString("name"));
        country.setIdLanguage(resultSet.getInt("id_language"));
        country.setIdImage(resultSet.getInt("id_image"));
    }

    @Override
    public void create(Country object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,country.getName());
            preparedStatement.setInt(2,country.getIdLanguage());
            preparedStatement.setInt(3,country.getIdImage());
            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Country> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Country>countryList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Country country = new Country();
                setParameterToCountry(country,resultSet);
                countryList.add(country);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return countryList;
    }

    @Override
    public Country getByID(int id) throws SQLException, ConnectionPoolException {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY);
            if(resultSet.next()){
               setParameterToCountry(country,resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(int id, Country object) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,country.getName());
            preparedStatement.setInt(2,country.getIdLanguage());
            preparedStatement.setInt(3,country.getIdImage());
            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.setInt(1,country.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
