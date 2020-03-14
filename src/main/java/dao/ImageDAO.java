package dao;
import entity.Image;

import java.util.List;

public interface ImageDAO {
    void add(Image image);
    List<Image> getAll();
    Image getById(Integer id);
    void update(Image image);
    void remove(Image image);
}
