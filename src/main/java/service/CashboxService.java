package service;

import dao.CashboxDAO;
import entity.Cashbox;
import connection.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CashboxService  extends ConnectionPool implements CashboxDAO {

    Connection connection = getConnection();

    @Override
    public void add(Cashbox cashbox) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into cashbox (id_employee, id_client, id_tour, amount, date) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,cashbox.getIdEmployee());
            preparedStatement.setInt(2,cashbox.getIdClient());
            preparedStatement.setInt(3,cashbox.getIdTour());
            preparedStatement.setInt(4,cashbox.getAmout());
            preparedStatement.setDate(5,cashbox.getDate());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Cashbox> getAll() {
        List<Cashbox> cashboxList = new ArrayList<>();
        String sql = "select * from cashbox";

        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Cashbox cashbox = new Cashbox();
                cashbox.setIdEmployee(resultSet.getInt("id_employee"));
                cashbox.setIdClient(resultSet.getInt("id_client"));
                cashbox.setIdTour(resultSet.getInt("id_tour"));
                cashbox.setAmout(resultSet.getInt("amount"));
                cashbox.setDate(resultSet.getDate("date"));

                cashboxList.add(cashbox);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashboxList;
    }

    @Override
    public Cashbox getById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "select * from cashbox where id_client=?";
        Cashbox cashbox = new Cashbox();
        ResultSet resultSet = preparedStatement.executeQuery();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(2,id);
            cashbox.setIdEmployee(resultSet.getInt("id_employee"));
            cashbox.setIdClient(resultSet.getInt("id_client"));
            cashbox.setIdTour(resultSet.getInt("id_tour"));
            cashbox.setAmout(resultSet.getInt("amount"));
            cashbox.setDate(resultSet.getDate("date"));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cashbox;
    }

    @Override
    public void update(Cashbox cashbox) {
        PreparedStatement preparedStatement = null;

        String sql = "update cashbox set id_employee = ?, id_client = ?, id_tour = ?, amount = ?, dateset = ?  where id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1,cashbox.getIdEmployee());
            preparedStatement.setInt(2,cashbox.getIdClient());
            preparedStatement.setInt(3,cashbox.getIdTour());
            preparedStatement.setInt(4,cashbox.getAmout());
            preparedStatement.setDate(5,cashbox.getDate());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Cashbox cashbox) {
        PreparedStatement preparedStatement = null;
        String sql = "delete  from  cashbox where id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cashbox.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
