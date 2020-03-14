package dao;
import entity.Language;

import java.util.List;

public interface LanguageDAO {
    void add(Language language);
    List<Language> getAll();
    Language getById(Integer id);
    void update(Language language);
    void remove(Language language);
}
