package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.CountryDAO;
import entity.Country;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl implements CountryDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private Country country = new Country();
    private static final Logger LOGGER = Logger.getLogger(CountryDaoImpl.class);
    private static final String ADD_QUERY =  "insert into country (id_country, name, id_language, id_image) values (?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from country";
    private static final String GET_BY_ID_QUERY = "select name, id_language, id_image from country where id_country = ?";
    private static final String UPDATE_QUERY = "update country set name = ?, id_language = ?, id_image = ?, where id_country = ?";
    private static final String REMOVE_QUERY =  "delete  from  country where id_country = ?";

    private Country setParameterToCountry(ResultSet resultSet) throws SQLException {
        Country country = new Country();
        country.setName(resultSet.getString("name"));
        country.setIdLanguage(resultSet.getInt("id_language"));
        country.setIdImage(resultSet.getInt("id_image"));
        return country;
    }

    @Override
    public void create(Country object) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,country.getName());
            newData.setInt(2,country.getIdLanguage());
            newData.setInt(3,country.getIdImage());
            newData.executeQuery();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Country> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Country> countries = new ArrayList<>();
        CountryDaoImpl countryDao = new CountryDaoImpl();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                countries.add(countryDao.setParameterToCountry(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return countries;
    }

    @Override
    public List<Country> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Country> countries = new ArrayList<>();
        CountryDaoImpl countryDao = new CountryDaoImpl();
        try {
            PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
               countries.add(countryDao.setParameterToCountry(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return countries;
    }

    @Override
    public void update(Country object) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,country.getName());
            newData.setInt(2,country.getIdLanguage());
            newData.setInt(3,country.getIdImage());
            newData.setInt(4,country.getId());
            newData.executeQuery();
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
