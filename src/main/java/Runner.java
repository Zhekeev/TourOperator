import connection.ConnectionPoolException;
import dao.ServiceDAO;
import dao.impl.ClientDaoImp;
import dao.impl.ServiceDaoImp;
import entity.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;

public class Runner {
    public static void main(String[] args) throws SQLException, ConnectionPoolException {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2005,Calendar.APRIL,10);
        ClientDaoImp clientDaoImp = new ClientDaoImp();
        Client client = new Client();
        client.setLogin("login");
        client.setPassword("password");
        client.setFirstName("Lebron");
        client.setLastName("James");
        client.setPhoneNumber(" ");
        client.setIdNumber("050505158754");
        client.setDateOfId(new java.sql.Date(calendar.getTime().getTime()));

        Service service = new Service();
        ServiceDaoImp serviceDaoImp = new ServiceDaoImp();
        service.setName("Аренда транспорта");
        service.setDescription("Вам предоставят транспорт на аренду, на весь срок вашего отдыха");
        service.setPrice(BigDecimal.valueOf(125000));
        //serviceDaoImp.create(service);
      //  serviceDaoImp.update(4,service);

        //clientDaoImp.create(client);
        //System.out.println(clientDaoImp.getByID(1));
        /*List<Client> clientList = clientDaoImp.getAll(); //   work
        for (Client c: clientList) {
            System.out.println(c);
        }*/
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
