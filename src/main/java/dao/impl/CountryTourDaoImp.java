package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.CountryTourDAO;
import entity.CountryTour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryTourDaoImp implements CountryTourDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private CountryTour countryTour = new CountryTour();
    private static final String ADD_QUERY =  "insert into country_tour (id_tour, id_country) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from country_tour";
    private static final String GET_BY_ID_QUERY = "select * from country_tour where id_tour = ";
    private static final String UPDATE_QUERY = "update country_tour set id_country = ?, where id_tour= ";
    private static final String REMOVE_QUERY =  "delete  from  country_tour where id_tour=";

    public void setParameterToCountryTour(CountryTour countryTour,ResultSet resultSet) throws SQLException {
        countryTour.setIdTour(resultSet.getInt("id_tour"));
        countryTour.setIdCountry(resultSet.getInt("id_country"));
    }

    @Override
    public void create(CountryTour object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setInt(1,countryTour.getIdTour());
            preparedStatement.setInt(2,countryTour.getIdCountry());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<CountryTour> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<CountryTour> countryToursList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                CountryTour countryTour = new CountryTour();
                setParameterToCountryTour(countryTour,resultSet);
                countryToursList.add(countryTour);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return countryToursList;
    }

    @Override
    public CountryTour getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()) {
                setParameterToCountryTour(countryTour,resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return countryTour;
    }

    @Override
    public void update(int id, CountryTour object) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setInt(1,countryTour.getIdTour());
            preparedStatement.setInt(2,countryTour.getIdCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ConnectionPoolException {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.setInt(1,countryTour.getIdTour());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

