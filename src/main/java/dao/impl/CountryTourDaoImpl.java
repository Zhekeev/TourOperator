package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.CountryTourDAO;
import entity.CountryTour;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryTourDaoImpl implements CountryTourDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private CountryTour countryTour = new CountryTour();
    private static final Logger LOGGER = Logger.getLogger(CountryDaoImpl.class);
    private static final String ADD_QUERY =  "insert into country_tour (id_tour, id_country) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from country_tour";
    private static final String GET_BY_ID_QUERY = "select id_tour, id_country from country_tour where id_tour = ?";
    private static final String UPDATE_QUERY = "update country_tour set id_country = ?, where id_tour = ?";
    private static final String REMOVE_QUERY =  "delete  from  country_tour where id_tour = ?";

    private CountryTour setParameterToCountryTour(ResultSet resultSet) throws SQLException {
        CountryTour countryTour = new CountryTour();
        countryTour.setIdTour(resultSet.getInt("id_tour"));
        countryTour.setIdCountry(resultSet.getInt("id_country"));
        return countryTour;
    }

    @Override
    public void create(CountryTour object) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setInt(1,countryTour.getIdTour());
            newData.setInt(2,countryTour.getIdCountry());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<CountryTour> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<CountryTour> countryTours = new ArrayList<>();
        CountryTourDaoImpl countryTourDao = new CountryTourDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                countryTours.add(countryTourDao.setParameterToCountryTour(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return countryTours;
    }

    @Override
    public CountryTour  getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        CountryTourDaoImpl countryTourDao = new CountryTourDaoImpl();
        List<CountryTour> countryTours = new ArrayList<>();
        CountryTour countryTour = null;
        try{
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()) {
                countryTours.add(countryTourDao.setParameterToCountryTour(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return countryTour;
    }

    @Override
    public void update(int id,CountryTour countryTour) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setInt(1,countryTour.getIdCountry());
            newData.setInt(2,countryTour.getIdTour());
            newData.executeUpdate();
        } catch (SQLException e) {
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

