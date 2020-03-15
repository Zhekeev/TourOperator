package entity;

import java.sql.Date;
import java.util.Objects;

public class Client {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String idNumber;
    private Date dateOfId;

    public  Client (){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getDateOfId() {
        return dateOfId;
    }

    public void setDateOfId(Date dateOfId) {
        this.dateOfId = dateOfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(phoneNumber, client.phoneNumber) &&
                Objects.equals(idNumber, client.idNumber) &&
                Objects.equals(dateOfId, client.dateOfId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, idNumber, dateOfId);
    }

    @Override
    public String toString() {
        return "Client{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", idNumber='" + idNumber + '\'' +
                ", dateOfId=" + dateOfId +
                '}';
    }
}
