import service.ClientService;
import entity.*;

public class Runner {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        Client client = new Client();
        client.setFirstName("Jack");
        client.setLastName("Sparrow");
        client.setPhoneNumber(877546264);
        client.setIdNumber("990411545623");
        client.setDateOfId(new java.sql.Date(2015,2,15));

        clientService.add(client);
    }
}
