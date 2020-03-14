package dao;
import entity.Service;

import java.util.List;

public interface ServiceDAO {
    void add(Service service);
    List<Service> getAll();
    Service getById(Integer id);
    void update(Service service);
    void remove(Service service);
}
