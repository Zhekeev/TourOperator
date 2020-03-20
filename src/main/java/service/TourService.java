package service;

import connection.ConnectionPool;
import dao.TourDAO;
import entity.ServiceContract;
import entity.Tour;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourService extends ConnectionPool implements TourDAO {

    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Tour tour = new Tour();
    private static final String ADD_QUERY =  "insert into tour (name , price , duration, id_language, id_image) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from tour";
    private static final String GET_BY_ID_QUERY = "select * from tour where id_tour = ";
    private static final String UPDATE_QUERY = "update tour set name = ? , price = ?, duration = ?, id_language = ?, id_image = ? where id_tour = ";
    private static final String REMOVE_QUERY =  "delete from tour where id_tour = ";

    @Override
    public void addTour(Tour tour) {
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,tour.getName());
            preparedStatement.setBigDecimal(2,tour.getPrice());
            preparedStatement.setInt(3,tour.getDuration());
            preparedStatement.setInt(4,tour.getIdLanguage());
            preparedStatement.setInt(5,tour.getIdImage());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Tour> getAll() {
        List<Tour> tourList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id_tour"));
                tour.setName(resultSet.getString("name"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setIdLanguage(resultSet.getInt("id_language"));
                tour.setIdImage(resultSet.getInt("id_image"));
                tourList.add(tour);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return tourList;
    }

    @Override
    public Tour getById(Integer id) {
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                tour.setId(resultSet.getInt("id_tour"));
                tour.setName(resultSet.getString("name"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setIdLanguage(resultSet.getInt("id_language"));
                tour.setIdImage(resultSet.getInt("id_image"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tour;
    }

    @Override
    public void update(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,tour.getName());
            preparedStatement.setBigDecimal(2,tour.getPrice());
            preparedStatement.setInt(3,tour.getDuration());
            preparedStatement.setInt(4,tour.getIdLanguage());
            preparedStatement.setInt(5,tour.getIdImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
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
