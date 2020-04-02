package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Tour {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer duration;
    private String description;
    private Integer idImage;

    public Tour(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                Objects.equals(name, tour.name) &&
                Objects.equals(price, tour.price) &&
                Objects.equals(duration, tour.duration) &&
                Objects.equals(description, tour.description) &&
                Objects.equals(idImage, tour.idImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, duration, description, idImage);
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", duration=" + duration +
                ", description='" + description + '\'' +
                ", idImage=" + idImage +
                '}';
    }
}
