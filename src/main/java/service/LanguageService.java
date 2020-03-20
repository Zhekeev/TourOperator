package service;

import connection.ConnectionPool;
import dao.LanguageDAO;
import entity.Language;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LanguageService extends ConnectionPool implements LanguageDAO {

    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Language language = new Language();
    private static final String ADD_QUERY =  "insert into language (name) values (?)";
    private static final String GET_ALL_QUERY = "select * from language";
    private static final String GET_BY_ID_QUERY = "select * from language where id_language = ";
    private static final String UPDATE_QUERY = "update language set name = ? where id_language = ";
    private static final String REMOVE_QUERY =  "delete  from language where id_language = ";

    @Override
    public void addLanguage(Language language) {
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,language.getName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Language> getAll() {
        List<Language> languageList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Language language = new Language();
                language.setId(resultSet.getInt("id_language"));
                language.setName(resultSet.getString("name"));
                languageList.add(language);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return languageList;
    }

    @Override
    public Language getById(Integer id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                language.setId(resultSet.getInt("id_language"));
                language.setName(resultSet.getString("name"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return language;
    }

    @Override
    public void update(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,language.getName());
            preparedStatement.executeUpdate();
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
