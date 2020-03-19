package dao;
import entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    void addClient(Client client);
    List<Client> getAllClient();
    Client getById(Integer id) throws SQLException;
    void update( Integer id);
    void remove( Integer id);
}
