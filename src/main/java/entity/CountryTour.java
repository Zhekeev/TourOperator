package entity;

import java.util.Objects;

public class CountryTour {
    private Integer idTour;
    private Integer idCountry;

    public CountryTour(){

    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
    }

    public Integer getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Integer idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryTour that = (CountryTour) o;
        return Objects.equals(idTour, that.idTour) &&
                Objects.equals(idCountry, that.idCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTour, idCountry);
    }

    @Override
    public String toString() {
        return "CountryTourDAO{" +
                "idTour=" + idTour +
                ", idCountry=" + idCountry +
                '}';
    }
}
