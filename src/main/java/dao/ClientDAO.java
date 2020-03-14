package dao;
import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    void add(Client client);
    List<Client> getAll();
    Client getById(Integer id) throws SQLException;
    void update(Client client);
    void remove(Client client);
}
