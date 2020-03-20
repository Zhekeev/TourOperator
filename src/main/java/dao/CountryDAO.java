package dao;
import entity.Country;

import java.util.List;

public interface CountryDAO {
    void addCountry(Country country);
    List<Country> getAll();
    Country getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
