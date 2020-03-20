package dao;
import entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    List<Employee> getAll();
    Employee getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
