package entity.dto;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class ContractDTO {
    private String firstNameClient;
    private String lastNameClient;
    private String nameTour;
    private Date tourStartDate;
    private Date tourFinishDate;
    private BigDecimal price;

    public ContractDTO() {
    }

    public String getFirstNameClient() {
        return firstNameClient;
    }

    public void setFirstNameClient(String firstNameClient) {
        this.firstNameClient = firstNameClient;
    }

    public String getLastNameClient() {
        return lastNameClient;
    }

    public void setLastNameClient(String lastNameClient) {
        this.lastNameClient = lastNameClient;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContractDTO contractDto = (ContractDTO) o;
        return Objects.equals(firstNameClient, contractDto.firstNameClient) &&
                Objects.equals(nameTour, contractDto.nameTour) &&
                Objects.equals(tourStartDate, contractDto.tourStartDate) &&
                Objects.equals(tourFinishDate, contractDto.tourFinishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNameClient, nameTour, tourStartDate, tourFinishDate);
    }

    @Override
    public String toString() {
        return "DTO{" +
                "nameCLient='" + firstNameClient + '\'' +
                ", nameTour='" + nameTour + '\'' +
                ", tourStartDate=" + tourStartDate +
                ", tourFinishDate=" + tourFinishDate +
                '}';
    }
}
