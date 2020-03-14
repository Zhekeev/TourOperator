package dao;
import entity.Cashbox;

import java.sql.SQLException;
import java.util.List;

public interface CashboxDAO {
    void add(Cashbox cashbox);
    List<Cashbox> getAll();
    Cashbox getById(Integer id) throws SQLException;
    void update(Cashbox cashbox);
    void remove(Cashbox cashbox);
}
