package dao;
import entity.Cashbox;

import java.sql.SQLException;
import java.util.List;

public interface CashboxDAO {
    void addCashbox(Cashbox cashbox);
    List<Cashbox> getAll();
    Cashbox getById(Integer id) throws SQLException;
    void update (Integer id);
    void remove(Integer id);
}
