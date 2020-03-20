package dao;
import entity.Tour;

import java.util.List;

public interface TourDAO {
    void addTour(Tour tour);
    List<Tour> getAll();
    Tour getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
