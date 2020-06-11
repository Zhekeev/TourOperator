package entity;
import java.math.BigDecimal;
import java.util.Objects;

public class Cashbox {
    private Integer idClient;
    private Integer idTour;
    private BigDecimal amount;
    private String date;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
