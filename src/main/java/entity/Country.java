package entity;

import java.util.Objects;

public class Country {
    private Integer id;
    private String name;
    private Integer idLanguage;
    private Integer idImage;

    public Country(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public Integer getIdImage() {
        return idImage;
    }

    public void setIdImage(Integer idImage) {
        this.idImage = idImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(name, country.name) &&
                Objects.equals(idLanguage, country.idLanguage) &&
                Objects.equals(idImage, country.idImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, idLanguage, idImage);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idLanguage=" + idLanguage +
                ", idImage=" + idImage +
                '}';
    }
}
