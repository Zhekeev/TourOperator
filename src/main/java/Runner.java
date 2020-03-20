import service.ClientService;
import entity.*;
import service.LanguageService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2012,Calendar.DECEMBER,12);
        ClientService clientService = new ClientService();
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
        Image image = new Image();
        Language language = new Language();
        language.setName("Russian");
        LanguageService languageService = new LanguageService();
       // languageService.addLanguage(language);

    }
}
