import service.ClientService;
import entity.*;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        ClientService clientService = new ClientService();
        calendar.set(2005,Calendar.DECEMBER,25);
        Date date = new Date();
        Client client = new Client();
        client.setFirstName("Michael");
        client.setLastName("Jordan");
        client.setPhoneNumber("87020235566");
        client.setIdNumber("69024554525");
        client.setDateOfId(new java.sql.Date(calendar.getTime().getTime()));

        //clientService.add(client);           work
/*
        List<Client> clientList = clientService.getAll();   work
        for (Client c: clientList) {
            System.out.println(c);
        }*/
        //clientService.update(client,1);       work
        //clientService.getById(1);             doesn't work!!!
        //clientService.remove(client,9);       work
    }
}
