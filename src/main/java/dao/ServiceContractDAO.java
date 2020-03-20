package dao;
import entity.ServiceContract;

import java.util.List;

public interface ServiceContractDAO {
    void addServiceContract(ServiceContract serviceContract);
    List<ServiceContract> getAll();
    ServiceContract getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
