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
        client.setIdNumber("690245555425");
        client.setDateOfId(new java.sql.Date(calendar.getTime().getTime()));

        //clientService.add(client);

        List<Client> clientList = clientService.getAll();
        for (Client c: clientList) {
            System.out.println(c);
        }
    }
}
