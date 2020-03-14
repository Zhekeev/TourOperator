package dao;
import entity.Tour;

import java.util.List;

public interface TourDAO {
    void add(Tour tour);
    List<Tour> getAll();
    Tour getById(Integer id);
    void update(Tour tour);
    void remove(Tour tour);
}
