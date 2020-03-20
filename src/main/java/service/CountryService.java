package service;

import connection.ConnectionPool;
import dao.CountryDAO;
import entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryService extends ConnectionPool implements CountryDAO {

    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Country country = new Country();
    private static final String ADD_QUERY =  "insert into country (id_country, name, id_language, id_image) values (?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from country";
    private static final String GET_BY_ID_QUERY = "select * from country where id_country = ";
    private static final String UPDATE_QUERY = "update country set name = ?, id_language = ?, id_image = ?, where id_country= ";
    private static final String REMOVE_QUERY =  "delete  from  country where id_country=";

    @Override
    public void addCountry(Country country) {
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
    public List<Country> getAll() {
        List<Country>countryList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Country country = new Country();
                country.setName(resultSet.getString("name"));
                country.setIdLanguage(resultSet.getInt("id_language"));
                country.setIdImage(resultSet.getInt("id_image"));
                countryList.add(country);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return countryList;
    }

    @Override
    public Country getById(Integer id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY);
            if(resultSet.next()){
                country.setName(resultSet.getString("name"));
                country.setIdLanguage(resultSet.getInt("id_language"));
                country.setIdImage(resultSet.getInt("id_image"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return country;
    }

    @Override
    public void update(Integer id) {
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
    public void remove(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
