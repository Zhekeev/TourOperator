package dao;
import entity.CountryTour;

import java.util.List;

public interface CountryTourDAO {
    void addCountryTour(CountryTour countryTour);
    List<CountryTour> getAll();
    CountryTour getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
