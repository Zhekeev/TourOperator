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
    private static final String ADD_QUERY =  "insert into image (name, link,id_tour) values (?,?,?)";
    private static final String GET_ALL_QUERY = "select * from image";
    private static final String GET_BY_ID_QUERY = "select name , link,id_tour from image where id = ?";
    private static final String UPDATE_QUERY = "update image set name = ?, link = ?,id_tour = ? where id = ?";
    private static final String REMOVE_QUERY =  "delete from image where id = ?";
    private static final String GET_ALL_BY_TOUR_ID="SELECT  image.id, image.name,image.link, id_tour FROM image where id_tour = ?;";

    private Image setParameterToImage(ResultSet resultSet) throws SQLException {
        Image image = new Image();
        image.setId(resultSet.getInt("id"));
        image.setName(resultSet.getString("name"));
        image.setLink(resultSet.getBytes("link"));
        image.setIdTour(resultSet.getInt("id_tour"));
        return image;
    }

    @Override
    public void create(Image image) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,image.getName());
            newData.setBytes(2,image.getLink());
            newData.setInt(3,image.getIdTour());
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
    public Image getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Image> images = new ArrayList<>();
        ImageDaoImpl imageDao = new ImageDaoImpl();
        Image image = null;
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
        return image;
    }

    @Override
    public void update(int id, Image image) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,image.getName());
            newData.setBytes(2,image.getLink());
            newData.setInt(3,image.getIdTour());
            newData.setInt(4,id);
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

    public List<Image> getAllByTourId(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Image> images =new ArrayList<>();
        Image image;
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_BY_TOUR_ID);
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                image = new Image();
                image.setId(resultSet.getInt("id"));
                image.setName(resultSet.getString("name"));
                image.setLink(resultSet.getBytes("link"));
                image.setIdTour(resultSet.getInt("id_image"));
                images.add(image);
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return images;
    }
}
