package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.ImageDAO;
import entity.Image;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageDaoImpl implements ImageDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(ImageDaoImpl.class);
    private static final String ADD_QUERY =  "insert into image (name, link) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from image";
    private static final String GET_BY_ID_QUERY = "select name , link from image where id_image = ?";
    private static final String UPDATE_QUERY = "update image set name = ?, link = ? where id_image = ?";
    private static final String REMOVE_QUERY =  "delete from image where id_image = ?";

    private Image setParameterToImage(ResultSet resultSet) throws SQLException {
        Image image = new Image();
        image.setId(resultSet.getInt("id_image"));
        image.setName(resultSet.getString("name"));
        image.setLink(resultSet.getString("link"));
        return image;
    }

    @Override
    public void create(Image image) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,image.getName());
            newData.setString(2,image.getLink());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Image> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Image> images = new ArrayList<>();
        ImageDaoImpl imageDao = new ImageDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                images.add(imageDao.setParameterToImage(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return images;
    }

    @Override
    public List<Image> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Image> images = new ArrayList<>();
        ImageDaoImpl imageDao = new ImageDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                images.add(imageDao.setParameterToImage(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return images;
    }

    @Override
    public void update(Image image) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY );
            newData.setString(1,image.getName());
            newData.setString(2,image.getLink());
            newData.setInt(3,image.getId());
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
