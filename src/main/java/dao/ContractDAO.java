package dao;
import entity.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    void addContract(Contract contract);
    List<Contract> getAll() throws SQLException;
    Contract getById(Integer id) throws SQLException;
    void update( Integer id);
    void remove(Integer id);
}
