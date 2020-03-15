package service;

import connection.ConnectionPool;
import dao.ContractDAO;
import entity.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractService extends ConnectionPool implements ContractDAO {
    private Connection connection = getConnection();

    @Override
    public void add(Contract contract) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into contract (id_client, id_employee, id_tour, tour_start_date, tour_finish_date) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,contract.getIdClient());
            preparedStatement.setInt(2,contract.getIdEmployee());
            preparedStatement.setInt(3,contract.getIdTour());
            preparedStatement.setDate(4,contract.getTourStartDate());
            preparedStatement.setDate(5,contract.getTourFinishDate());

            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Contract> getAll() {
        List<Contract> contractList = new ArrayList<>();
        String sql = "select * from contract";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Contract contract = new Contract();
                contract.setIdClient(resultSet.getInt("id_client"));
                contract.setIdEmployee(resultSet.getInt("id_employee"));
                contract.setIdTour(resultSet.getInt("id_tour"));
                contract.setTourStartDate(resultSet.getDate("tour_start_date"));
                contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public Contract getById(Integer id) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "select * from contract where id_contract=?";
        Contract contract = new Contract();
        ResultSet resultSet = preparedStatement.executeQuery();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            contract.setIdClient(resultSet.getInt("id_client"));
            contract.setIdEmployee(resultSet.getInt("id_employee"));
            contract.setIdTour(resultSet.getInt("id_tour"));
            contract.setTourStartDate(resultSet.getDate("tour_start_date"));
            contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public void update(Contract contract) {
        PreparedStatement preparedStatement = null;

        String sql = "update conctract set id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ?  where id_contract=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,contract.getIdClient());
            preparedStatement.setInt(2,contract.getIdEmployee());
            preparedStatement.setInt(3,contract.getIdTour());
            preparedStatement.setDate(4,contract.getTourStartDate());
            preparedStatement.setDate(5,contract.getTourFinishDate());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Contract contract) {
        PreparedStatement preparedStatement = null;
        String sql = "delete  from  contract where id_client=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, contract.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
