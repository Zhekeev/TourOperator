package dao;
import entity.CountryTour;

import java.util.List;

public interface CountryTourDAO {
    void add(CountryTour countryTour);
    List<CountryTour> getAll();
    CountryTour getById(Integer id);
    void update(CountryTour countryTour);
    void remove(CountryTour countryTour);
}
