package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.TourDAO;
import entity.Tour;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDaoImpl implements TourDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(ClientDaoImpl.class);
    private static final String ADD_QUERY =  "insert into tour ( name , price , duration, description, id_image) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from tour";
    private static final String GET_BY_ID_QUERY = "select name, price, duration, description, id_image from tour where id_tour = ?";
    private static final String UPDATE_QUERY = "update tour set name = ? , price = ?, duration = ?, description = ?, id_image = ? where id_tour = ?";
    private static final String REMOVE_QUERY =  "delete from tour where id_tour = ?";

    private Tour setParameterToTour(ResultSet resultSet) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt("id_tour"));
        tour.setName(resultSet.getString("name"));
        tour.setPrice(resultSet.getBigDecimal("price"));
        tour.setDescription(resultSet.getString("description"));
        tour.setIdImage(resultSet.getInt("id_image"));
        return tour;
    }

    @Override
    public void create(Tour tour) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,tour.getName());
            newData.setBigDecimal(2,tour.getPrice());
            newData.setInt(3,tour.getDuration());
            newData.setString(4,tour.getDescription());
            newData.setInt(5,tour.getIdImage());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Tour> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Tour> tours = new ArrayList<>();
        TourDaoImpl tourDao = new TourDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                tours.add(tourDao.setParameterToTour(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return tours;
    }

    @Override
    public List<Tour> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Tour> tours = new ArrayList<>();
        TourDaoImpl tourDao = new TourDaoImpl();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
              tours.add(tourDao.setParameterToTour(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return tours;
    }

    @Override
    public void update(Tour tour) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,tour.getName());
            newData.setBigDecimal(2,tour.getPrice());
            newData.setInt(3,tour.getDuration());
            newData.setString(4,tour.getDescription());
            newData.setInt(5,tour.getIdImage());
            newData.setInt(6,tour.getId());
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
