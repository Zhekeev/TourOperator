package dao;

import connection.ConnectionPoolException;
import entity.Client;

import java.util.List;

public interface ClientDAO extends BaseDAO<Client>{
    void updatePassword(Client client) throws ConnectionPoolException;
    List<Client> getClientByName(String name) throws ConnectionPoolException;
    List<Client> getClientByLastName(String name) throws ConnectionPoolException;
}
