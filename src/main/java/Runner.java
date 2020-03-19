import service.ClientService;
import entity.*;

import javax.swing.text.html.Option;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        ClientService clientService = new ClientService();
        calendar.set(2012,Calendar.DECEMBER,12);
        Client client = new Client();
        client.setFirstName("Donald");
        client.setLastName("Trump");
        client.setPhoneNumber(" ");
        client.setIdNumber("000411658754");
        client.setDateOfId(new java.sql.Date(calendar.getTime().getTime()));

       //clientService.addClient(client);
/*
        List<Client> clientList = clientService.getAllClient(); //   work
        for (Client c: clientList) {
            System.out.println(c);
        }*/
        //clientService.update(1);       work
       //clientService.remove(11);
       // System.out.println(clientService.getById(8));  //work
    }
}
