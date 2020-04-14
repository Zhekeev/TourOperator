package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.EmployeeDAO;
import entity.Employee;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private ResultSet resultSet = null;
    private static final Logger LOGGER = Logger.getLogger(EmployeeDaoImpl.class);
    private static final String ADD_QUERY =  "insert into employee (first_name, last_name) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from employee";
    private static final String GET_BY_ID_QUERY = "select first_name = ?, last_name = ? from employee where id_employee = ?";
    private static final String UPDATE_QUERY = "update employee set first_name = ?, last_name = ? where id_employee= ?";
    private static final String REMOVE_QUERY =  "delete from employee where id_employee = ?";

    private Employee serParameterToEmployee(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("id_employee"));
        employee.setFirstName(resultSet.getString("fist_name"));
        employee.setLastName(resultSet.getString("last_name"));
        return employee;
    }

    @Override
    public void create(Employee employee) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(ADD_QUERY);
            newData.setString(1,employee.getFirstName());
            newData.setString(2,employee.getLastName());
            newData.executeUpdate();
        }catch (SQLException e){
            LOGGER.error(e);
        }
    }

    @Override
    public List<Employee> getAll() throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_ALL_QUERY);
            resultSet = newData.executeQuery();
            while (resultSet.next()){
                employees.add(employeeDao.serParameterToEmployee(resultSet));
            }
        }catch (SQLException e){
            LOGGER.error(e);
        }
        return employees;
    }

    @Override
    public List<Employee> getByID(int id) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        List<Employee> employees = new ArrayList<>();
        try {
            PreparedStatement newData =connection.prepareStatement(GET_BY_ID_QUERY);
            newData.setInt(1, id);
            resultSet = newData.executeQuery();
            if(resultSet.next()){
                employees.add(employeeDao.serParameterToEmployee(resultSet));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void update(Employee employee) throws ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            PreparedStatement newData = connection.prepareStatement(UPDATE_QUERY);
            newData.setString(1,employee.getFirstName());
            newData.setString(2,employee.getLastName());
            newData.setInt(3,employee.getId());
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
