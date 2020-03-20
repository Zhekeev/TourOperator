package dao;
import entity.Image;

import java.util.List;

public interface ImageDAO {
    void addImage(Image image);
    List<Image> getAll();
    Image getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
