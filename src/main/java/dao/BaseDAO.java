package dao;

import connection.ConnectionPoolException;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface BaseDAO<T> {
    void create(T object) throws SQLException, ConnectionPoolException, ParseException;

    List<T> getAll() throws SQLException, ConnectionPoolException;

    T getByID(int id) throws SQLException, ConnectionPoolException;

    void update(int id, T object) throws SQLException, ConnectionPoolException;

    void delete(int id) throws SQLException, ConnectionPoolException;

}
