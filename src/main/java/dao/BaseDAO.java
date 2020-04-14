package dao;

import connection.ConnectionPoolException;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
    void create(T object) throws SQLException, ConnectionPoolException;

    List<T> getAll() throws SQLException, ConnectionPoolException;

    List<T> getByID(int id) throws SQLException, ConnectionPoolException;

    void update(T object) throws SQLException, ConnectionPoolException;

    void delete(int id) throws SQLException, ConnectionPoolException;
}
