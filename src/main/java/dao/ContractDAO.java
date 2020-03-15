package dao;
import entity.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractDAO {
    void add(Contract contract);
    List<Contract> getAll();
    Contract getById(Integer id) throws SQLException;
    void update(Contract contract);
    void remove(Contract contract);
}
