package dto;

import java.sql.Date;
import java.util.Objects;

public class DTO {
    private String nameCLient;
    private String nameTour;
    private Date tourStartDate;
    private Date tourFinishDate;

    public DTO() {
    }

    public String getNameCLient() {
        return nameCLient;
    }

    public void setNameCLient(String nameCLient) {
        this.nameCLient = nameCLient;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public Date getTourStartDate() {
        return tourStartDate;
    }

    public void setTourStartDate(Date tourStartDate) {
        this.tourStartDate = tourStartDate;
    }

    public Date getTourFinishDate() {
        return tourFinishDate;
    }

    public void setTourFinishDate(Date tourFinishDate) {
        this.tourFinishDate = tourFinishDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTO dto = (DTO) o;
        return Objects.equals(nameCLient, dto.nameCLient) &&
                Objects.equals(nameTour, dto.nameTour) &&
                Objects.equals(tourStartDate, dto.tourStartDate) &&
                Objects.equals(tourFinishDate, dto.tourFinishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCLient, nameTour, tourStartDate, tourFinishDate);
    }

    @Override
    public String toString() {
        return "DTO{" +
                "nameCLient='" + nameCLient + '\'' +
                ", nameTour='" + nameTour + '\'' +
                ", tourStartDate=" + tourStartDate +
                ", tourFinishDate=" + tourFinishDate +
                '}';
    }
}
