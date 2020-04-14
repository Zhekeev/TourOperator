import connection.ConnectionPoolException;
import dao.impl.ClientDaoImpl;
import entity.*;

import java.sql.SQLException;
import java.util.Calendar;

public class Runner {
    public static void main(String[] args) throws SQLException, ConnectionPoolException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,Calendar.JUNE,2);
        ClientDaoImpl clientDaoImpl = new ClientDaoImpl();
        Client client = new Client();
        client.setLogin("kazakh_007");
        client.setPassword("birekiush");
        client.setFirstName("Batyrbek");
        client.setLastName("Nursultanov");
        client.setPhoneNumber("87779992020 ");
        client.setIdNumber("020599350150");
        client.setDateOfId(new java.sql.Date(calendar.getTime().getTime()));
        // Service service = new Service();
        // ServiceDaoImp serviceDaoImp = new ServiceDaoImp();
        // service.setName("Аренда транспорта");
        // service.setDescription("Вам предоставят транспорт на аренду, на весь срок вашего отдыха");
        // service.setPrice(BigDecimal.valueOf(125000));

        /* List<Client> clientList = clientDaoImpl.getAll(); //   get all
                for (Client c: clientList) {
                    System.out.println(c);
            }*/
        // client.setLogin("yergazy");
        // client.setPassword("310925");
        // clientDaoImpl.updatePassword(client);  // password update
        // System.out.println(clientDaoImpl.getByID(1)); // get by id
        // clientDaoImpl.update(client);
        // clientDaoImpl.create(client);
        // clientDaoImpl.delete(5);
        // serviceDaoImp.create(service);
        // serviceDaoImp.update(4,service);
        // clientDaoImp.updatePassword(1, client);
        // clientDaoImp.create(client);
        // List<Client> clientList = clientDaoImpl.getByID(1);

        //clientService.update(1);       work
       //clientService.remove(11);
       // System.out.println(clientService.getById(8));  //work
      //  Image image = new Image();
       // Language language = new Language();
       // language.setName("Russian");
       // LanguageDaoImp languageDaoImp = new LanguageDaoImp();
       // languageService.addLanguage(language);

    }
}
