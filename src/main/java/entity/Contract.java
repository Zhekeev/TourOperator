package entity;

import java.sql.Date;
import java.util.Objects;

public class Contract {
    private Integer id;
    private Integer idEmployee;
    private Integer idClient;
    private Integer idTour;
    private Date tourStartDate;
    private Date tourFinishDate;

    public Contract(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdTour() {
        return idTour;
    }

    public void setIdTour(Integer idTour) {
        this.idTour = idTour;
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
        Contract contract = (Contract) o;
        return Objects.equals(id, contract.id) &&
                Objects.equals(idEmployee, contract.idEmployee) &&
                Objects.equals(idClient, contract.idClient) &&
                Objects.equals(idTour, contract.idTour) &&
                Objects.equals(tourStartDate, contract.tourStartDate) &&
                Objects.equals(tourFinishDate, contract.tourFinishDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idEmployee, idClient, idTour, tourStartDate, tourFinishDate);
    }

    @Override
    public String toString() {
        return "ContractDAO{" +
                "id=" + id +
                ", idEmployee=" + idEmployee +
                ", idClient=" + idClient +
                ", idTour=" + idTour +
                ", tourStartDate=" + tourStartDate +
                ", tourFinishDate=" + tourFinishDate +
                '}';
    }
}
