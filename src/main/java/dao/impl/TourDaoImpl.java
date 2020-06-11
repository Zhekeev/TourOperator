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
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private static final String ADD_QUERY =  "insert into tour ( name_ru,name_eng , price , duration, description_ru,desctioption_eng) values (?,?,?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select id,name_ru,name_eng,price,duration,description_ru,description_eng from tour";
    private static final String GET_ALL_BY_ID_QUERY = "select id,name_ru,name_eng,price,duration,description_ru,description_eng from tour where id = ?";
    private static final String GET_TOUR_BY_ID_COUNTRY = "select * from tour_operator.tour \n" +
            "join country_tour on tour.id = country_tour.id_tour\n" +
            "join country on country_tour.id_country = country.id\n" +
            "where country.id = ?";
    private static final String GET_BY_ID_QUERY = "select id, name_ru, name_eng, price, duration, description_ru,description_eng from tour where id = ?";
    private static final String UPDATE_QUERY = "update tour set name_ru = ?,name_eng = ?, price = ?, duration = ?, description_ru = ?,description_eng = ? where id = ?";
    private static final String REMOVE_QUERY =  "delete from tour where id = ?";

    private Tour setParameterToTour(ResultSet resultSet) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getInt("id_tour"));
        tour.setNameRu(resultSet.getString("name_ru"));
        tour.setNameEng(resultSet.getString("name_eng"));
        tour.setPrice(resultSet.getBigDecimal("price"));
        tour.setDescriptionRu(resultSet.getString("description_ru"));
        tour.setDescriptionEng(resultSet.getString("description_eng"));
        tour.setIdImage(resultSet.getInt("id_image"));
        return tour;
    }

    @Override
    public void create(Tour tour) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,tour.getNameRu());
            newData.setString(2,tour.getNameEng());
            newData.setBigDecimal(3,tour.getPrice());
            newData.setInt(4,tour.getDuration());
            newData.setString(5,tour.getDescriptionRu());
            newData.setString(6,tour.getDescriptionEng());
            newData.setInt(7,tour.getIdImage());
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
        try (  PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY)){
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setNameRu(resultSet.getString("name_ru"));
                tour.setNameEng(resultSet.getString("name_eng"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setDescriptionRu(resultSet.getString("description_ru"));
                tour.setDescriptionEng(resultSet.getString("description_eng"));
               /* tour.setIdImage(resultSet.getInt("id_image"));*/
                tours.add(tour);
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return tours;
    }

    public List<Tour> getAllbyCountry(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Tour> tours = new ArrayList<>();
        TourDaoImpl tourDao = new TourDaoImpl();
        try (  PreparedStatement newData =connection.prepareStatement(GET_TOUR_BY_ID_COUNTRY)){
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setNameRu(resultSet.getString("name_ru"));
                tour.setNameEng(resultSet.getString("name_eng"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setDescriptionRu(resultSet.getString("description_ru"));
                tour.setDescriptionEng(resultSet.getString("description_eng"));
                tours.add(tour);
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return tours;
    }

    public List<Tour> getAllbyId(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Tour> tours = new ArrayList<>();
        TourDaoImpl tourDao = new TourDaoImpl();
        try (PreparedStatement newData =connection.prepareStatement(GET_ALL_BY_ID_QUERY)){
            newData.setInt(1,id);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setNameRu(resultSet.getString("name_ru"));
                tour.setNameEng(resultSet.getString("name_eng"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setDescriptionRu(resultSet.getString("description_ru"));
                tour.setDescriptionEng(resultSet.getString("description_eng"));
                tour.setIdImage(resultSet.getInt("id_image"));
                tours.add(tour);
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return tours;
    }

    @Override
    public Tour getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        Tour tour = null;
        try(PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY)) {
            newData.setInt(1, id);
            ResultSet resultSet = newData.executeQuery();
            while (resultSet.next()){
                tour = new Tour();
                tour.setId(resultSet.getInt("id"));
                tour.setNameRu(resultSet.getString("name_ru"));
                tour.setNameEng(resultSet.getString("name_eng"));
                tour.setPrice(resultSet.getBigDecimal("price"));
                tour.setDuration(resultSet.getInt("duration"));
                tour.setDescriptionRu(resultSet.getString("description_ru"));
                tour.setDescriptionEng(resultSet.getString("description_eng"));
                tour.setIdImage(resultSet.getInt("id_image"));
                return tour;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return tour;
    }

    @Override
    public void update(int id,Tour tour) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try(PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY)) {
            newData.setString(1,tour.getNameRu());
            newData.setString(2,tour.getNameEng());
            newData.setBigDecimal(3,tour.getPrice());
            newData.setInt(4,tour.getDuration());
            newData.setString(5,tour.getDescriptionRu());
            newData.setString(6,tour.getDescriptionEng());
            newData.setInt(7, id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }

    @Override
    public void delete(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try ( PreparedStatement newData = connection.prepareStatement(REMOVE_QUERY)){
            newData.setInt(1,id);
            newData.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e);
        }
    }
}
