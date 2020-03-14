package dao;
import entity.Contract;

import java.util.List;

public interface ContractDAO {
    void add(Contract contract);
    List<Contract> getAll();
    Contract getById(Integer id);
    void update(Contract contract);
    void remove(Contract contract);
}
