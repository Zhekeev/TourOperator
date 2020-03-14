package entity;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Objects;

public class Cashbox {
    private Integer idEmployee;
    private Integer idClient;
    private Integer idTour;
    private Integer amout;
    private Date date;

    public Cashbox(){

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

    public Integer getAmout() {
        return amout;
    }

    public void setAmout(Integer amout) {
        this.amout = amout;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashbox cashbox = (Cashbox) o;
        return Objects.equals(idEmployee, cashbox.idEmployee) &&
                Objects.equals(idClient, cashbox.idClient) &&
                Objects.equals(idTour, cashbox.idTour) &&
                Objects.equals(amout, cashbox.amout) &&
                Objects.equals(date, cashbox.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, idClient, idTour, amout, date);
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "idEmployee=" + idEmployee +
                ", idClient=" + idClient +
                ", idTour=" + idTour +
                ", amout=" + amout +
                ", date=" + date +
                '}';
    }
}
