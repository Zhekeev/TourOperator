package service;

import connection.ConnectionPool;
import dao.ImageDAO;
import entity.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImageService extends ConnectionPool implements ImageDAO {

    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Image image = new Image();
    private static final String ADD_QUERY =  "insert into image (name, link) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from image";
    private static final String GET_BY_ID_QUERY = "select * from image where id_image = ";
    private static final String UPDATE_QUERY = "update image set name = ?, link = ? where id_image = ";
    private static final String REMOVE_QUERY =  "delete  from image where id_image = ";

    @Override
    public void addImage(Image image) {
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
    public List<Image> getAll() {
        List<Image> imageList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Image image = new Image();
                image.setId(resultSet.getInt("id_image"));
                image.setName(resultSet.getString("name"));
                image.setLink(resultSet.getString("link"));
                imageList.add(image);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    public Image getById(Integer id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                image.setId(resultSet.getInt("id_image"));
                image.setName(resultSet.getString("name"));
                image.setLink(resultSet.getString("link"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public void update(Integer id) {
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
    public void remove(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
