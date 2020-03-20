package service;

import connection.ConnectionPool;
import dao.ContractDAO;
import entity.Contract;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractService extends ConnectionPool implements ContractDAO {
    private Connection connection = getConnection();
    private PreparedStatement preparedStatement = null;
    private Statement statement = null;
    private Contract contract = new Contract();
    private static final String ADD_QUERY = "insert into contract (id_client, id_employee, id_tour, tour_start_date, tour_finish_date) values (?,?,?,?,?)";
    private static final String GET_ALL_QUERY = "select * from contract";
    private static final String GET_BY_ID_QUERY = "select * from contract where id_contract= ";
    private static final String UPDATE_QUERY = "update conctract set id_client = ?, id_employee = ?, id_tour = ?, tour_start_date = ?, tour_finish_date = ?  where id_contract=?";
    private static final String REMOVE_QUERY = "delete  from  contract where id_client=?";

    @Override
    public void addContract(Contract contract) {
        try {
            preparedStatement = connection.prepareStatement(ADD_QUERY);
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
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY);
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
    public Contract getById(Integer id) {
        try{
            ResultSet resultSet = statement.executeQuery(GET_BY_ID_QUERY+id);
            contract.setIdContract(resultSet.getInt("id_contract"));
            contract.setIdClient(resultSet.getInt("id_client"));
            contract.setIdEmployee(resultSet.getInt("id_employee"));
            contract.setIdTour(resultSet.getInt("id_tour"));
            contract.setTourStartDate(resultSet.getDate("tour_start_date"));
            contract.setTourFinishDate(resultSet.getDate("tour_finish_date"));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return contract;
    }

    @Override
    public void update(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_QUERY + id);
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
    public void remove(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(REMOVE_QUERY + id);
            preparedStatement.setInt(1, contract.getIdClient());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
