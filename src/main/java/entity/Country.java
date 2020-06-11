package entity;

import java.util.Objects;

public class Country {
    private Integer id;
    private String nameRu;
    private String nameEng;

    public Country(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameRu() {
        return nameRu;
    }

    public void setNameRu(String nameRu) {
        this.nameRu = nameRu;
    }

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(nameRu, country.nameRu) &&
                Objects.equals(nameEng, country.nameEng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRu, nameEng);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", nameRu='" + nameRu + '\'' +
                ", nameEng='" + nameEng + '\'' +
                '}';
    }
}
