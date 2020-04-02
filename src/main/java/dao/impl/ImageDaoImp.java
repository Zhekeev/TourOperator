package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ImageDAO;
import entity.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDaoImp implements ImageDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Image image = new Image();
    private static final String ADD_QUERY =  "insert into image (name, link) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from image";
    private static final String GET_BY_ID_QUERY = "select * from image where id_image = ";
    private static final String UPDATE_QUERY = "update image set name = ?, link = ? where id_image = ";
    private static final String REMOVE_QUERY =  "delete  from image where id_image = ";

    private void setParameterToImage(Image image, ResultSet resultSet) throws SQLException {
        image.setId(resultSet.getInt("id_image"));
        image.setName(resultSet.getString("name"));
        image.setLink(resultSet.getString("link"));
    }
    @Override
    public void create(Image object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,image.getName());
            preparedStatement.setString(2,image.getLink());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Image getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                setParameterToImage(image,resultSet);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void update(int id, Image object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,image.getName());
            preparedStatement.setString(2,image.getLink());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Image> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Image> imageList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Image image = new Image();
                setParameterToImage(image,resultSet);
                imageList.add(image);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return imageList;
    }
}
