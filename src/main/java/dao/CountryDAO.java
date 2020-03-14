package dao;
import entity.Country;

import java.util.List;

public interface CountryDAO {
    void add(Country country);
    List<Country> getAll();
    Country getById(Integer id);
    void update(Country country);
    void remove(Country country);
}
