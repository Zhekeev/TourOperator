package dao;
import entity.ServiceContract;

import java.util.List;

public interface ServiceContractDAO {
    void add(ServiceContract serviceContract);
    List<ServiceContract> getAll();
    ServiceContract getById(Integer id);
    void update(ServiceContract serviceContract);
    void remove(ServiceContract serviceContract);
}
