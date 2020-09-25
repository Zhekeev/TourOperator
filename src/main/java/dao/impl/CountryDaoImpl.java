package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.CountryDAO;
import entity.Country;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constant.SqlConstant.*;

public class CountryDaoImpl implements CountryDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private Country country = new Country();
    private static final Logger LOGGER = Logger.getLogger(CountryDaoImpl.class);
    private static final String ADD_QUERY =  "insert into country (name_ru, name_eng) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from country";
    private static final String GET_BY_ID_QUERY = "select id, name_ru,name_eng from country where id = ?";
    private static final String UPDATE_QUERY = "update country set name_ru = ?,name_eng = ? where id = ?";
    private static final String REMOVE_QUERY =  "delete  from  country where id = ?";

    private Country setParameterToCountry(ResultSet resultSet) throws SQLException {
        Country country = new Country();
        country.setId(resultSet.getInt(ID));
        country.setNameRu(resultSet.getString(NAME_RU));
        country.setNameEng(resultSet.getString(NAME_ENG));
        return country;
    }

    @Override
    public void create(Country country) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(ADD_QUERY)){
            newData.setString(1,country.getNameRu());
            newData.setString(2,country.getNameEng());
            newData.executeUpdate();
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
    public Country getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        Country country = null;
        try (PreparedStatement newData = connection.prepareStatement(GET_BY_ID_QUERY)) {
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
               country = setParameterToCountry(resultSet);
               return country;
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return country;
    }

    @Override
    public void update(int id,Country country) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try (PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY)) {
            newData.setString(1,country.getNameRu());
            newData.setString(2,country.getNameEng());
            newData.setInt(3,id);
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
