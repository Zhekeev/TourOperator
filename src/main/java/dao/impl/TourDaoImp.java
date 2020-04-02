package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.TourDAO;
import entity.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDaoImp implements TourDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Tour tour = new Tour();
    private static final String ADD_QUERY =  "insert into tour ( name , price , duration, description, id_image) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from tour";
    private static final String GET_BY_ID_QUERY = "select * from tour where id_tour = ";
    private static final String UPDATE_QUERY = "update tour set name = ? , price = ?, duration = ?, description = ?, id_image = ? where id_tour = ";
    private static final String REMOVE_QUERY =  "delete from tour where id_tour = ";

    private void setParameterToTour(Tour tour, ResultSet resultSet) throws SQLException {
        tour.setId(resultSet.getInt("id_tour"));
        tour.setName(resultSet.getString("name"));
        tour.setPrice(resultSet.getBigDecimal("price"));
        tour.setDescription(resultSet.getString("description"));
        tour.setIdImage(resultSet.getInt("id_image"));
    }
    @Override
    public void create(Tour object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,tour.getName());
            preparedStatement.setBigDecimal(2,tour.getPrice());
            preparedStatement.setInt(3,tour.getDuration());
            preparedStatement.setString(4,tour.getDescription());
            preparedStatement.setInt(5,tour.getIdImage());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Tour getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
              setParameterToTour(tour,resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }

    @Override
    public void update(int id, Tour object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,tour.getName());
            preparedStatement.setBigDecimal(2,tour.getPrice());
            preparedStatement.setInt(3,tour.getDuration());
            preparedStatement.setString(4,tour.getDescription());
            preparedStatement.setInt(5,tour.getIdImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
    public List<Tour> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Tour> tourList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Tour tour = new Tour();
                setParameterToTour(tour,resultSet);
                tourList.add(tour);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tourList;
    }
}
