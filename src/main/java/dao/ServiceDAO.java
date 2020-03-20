package dao;
import entity.Service;

import java.util.List;

public interface ServiceDAO {
    void addService(Service service);
    List<Service> getAll();
    Service getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
