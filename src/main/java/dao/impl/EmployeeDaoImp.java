package dao.impl;

import connection.ConnectionPool;
import connection.ConnectionPoolException;
import dao.EmployeeDAO;
import entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImp implements EmployeeDAO {

    private Connection connection;
    private ConnectionPool connectionPool;
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private Employee employee = new Employee();
    private static final String ADD_QUERY =  "insert into employee (first_name, last_name) values (?,?)";
    private static final String GET_ALL_QUERY = "select * from employee";
    private static final String GET_BY_ID_QUERY = "select * from employee where id_employee = ";
    private static final String UPDATE_QUERY = "update employee set first_name = ?, last_name = ? where id_employee= ";
    private static final String REMOVE_QUERY =  "delete  from employee where id_employee=";

    private void serParameterToEmployee(Employee employee, ResultSet resultSet) throws SQLException {
        employee.setId(resultSet.getInt("id_employee"));
        employee.setFirstName(resultSet.getString("fist_name"));
        employee.setLastName(resultSet.getString("last_name"));
    }
    @Override
    public void create(Employee object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee getByID(int id) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_BY_ID_QUERY + id);
            if(resultSet.next()){
                serParameterToEmployee(employee,resultSet);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void update(int id, Employee object) throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
            preparedStatement.setString(1,employee.getFirstName());
            preparedStatement.setString(2,employee.getLastName());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
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
    public List<Employee> getAll() throws SQLException, ConnectionPoolException {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.takeConnection();
        List<Employee> employeeList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_QUERY);
            while (resultSet.next()){
                Employee employee = new Employee();
                serParameterToEmployee(employee,resultSet);
                employeeList.add(employee);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return employeeList;
    }
}
