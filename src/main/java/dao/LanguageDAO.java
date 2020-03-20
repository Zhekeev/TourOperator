package dao;
import entity.Language;

import java.util.List;

public interface LanguageDAO {
    void addLanguage(Language language);
    List<Language> getAll();
    Language getById(Integer id);
    void update(Integer id);
    void remove(Integer id);
}
