package entity;
import java.sql.Date;
import java.util.Objects;

public class Cashbox {
    private Integer idClient;
    private Integer idTour;
    private Integer amount;
    private Date date;

    public Cashbox(){

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        return Objects.equals(idClient, cashbox.idClient) &&
                Objects.equals(idTour, cashbox.idTour) &&
                Objects.equals(amount, cashbox.amount) &&
                Objects.equals(date, cashbox.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, idTour, amount, date);
    }

    @Override
    public String toString() {
        return "Cashbox{" +
                "idClient=" + idClient +
                ", idTour=" + idTour +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
