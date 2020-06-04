package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Tour {
    private Integer id;
    private String nameRu;
    private String nameEng;
    private BigDecimal price;
    private Integer duration;
    private String descriptionRu;
    private String descriptionEng;
    private Integer idImage;

    public Tour(){

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getDescriptionEng() {
        return descriptionEng;
    }

    public void setDescriptionEng(String descriptionEng) {
        this.descriptionEng = descriptionEng;
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
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id) &&
                Objects.equals(nameRu, tour.nameRu) &&
                Objects.equals(nameEng, tour.nameEng) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(duration, tour.duration) &&
                Objects.equals(descriptionRu, tour.descriptionRu) &&
                Objects.equals(descriptionEng, tour.descriptionEng) &&
                Objects.equals(idImage, tour.idImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameRu, nameEng, price, duration, descriptionRu, descriptionEng, idImage);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name_ru='" + nameRu + '\'' +
                ", name_eng='" + nameEng + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description_ru='" + descriptionRu + '\'' +
                ", description_eng='" + descriptionEng + '\'' +
                ", idImage=" + idImage +
                '}';
    }
}
