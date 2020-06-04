package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.LanguageDAO;
import entity.Language;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageDaoImpl implements LanguageDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(LanguageDaoImpl.class);
    private static final String ADD_QUERY =  "insert into language (name) values (?)";
    private static final String GET_ALL_QUERY = "select * from language";
    private static final String GET_BY_ID_QUERY = "select name from language where id_language = ?";
    private static final String UPDATE_QUERY = "update language set name = ? where id_language = ?";
    private static final String REMOVE_QUERY =  "delete  from language where id_language = ?";

    private Language setParameterToLanguage(ResultSet resultSet) throws SQLException {
        Language language = new Language();
        language.setId(resultSet.getInt("id_language"));
        language.setName(resultSet.getString("name"));
        return language;
    }

    @Override
    public void create(Language language) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,language.getName());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Language> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Language> languages = new ArrayList<>();
        LanguageDaoImpl languageDao = new LanguageDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                languages.add(languageDao.setParameterToLanguage(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return languages;
    }

    @Override
    public Language getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Language> languages = new ArrayList<>();
        LanguageDaoImpl languageDao = new LanguageDaoImpl();
        Language language = null;
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                languages.add(languageDao.setParameterToLanguage(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return language;
    }

    @Override
    public void update(int id,Language language) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,language.getName());
            newData.setInt(2,language.getId());
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
