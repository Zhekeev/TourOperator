package businesslogic;

import action.Action;
import connection.ConnectionPoolException;
import entity.Service;
import entity.Tour;
import entity.User;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Properties;

public class SendMail implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        Tour tour = (Tour) httpSession.getAttribute("tour");
        Service service = (Service) httpSession.getAttribute("service");
        BigDecimal totalAmount = (BigDecimal) httpSession.getAttribute("price");
        String clientEmail = user.getEmail();

        final String username = "jokerkaraganda@gmail.com";
        final String password = "aA31092532798";

        String from = "jokerkaraganda@gmail.com";
        String host = "smtp.gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        properties.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);


            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(clientEmail));
            message.setSubject("Ваш чек");
            message.setText("\n Чек на имя, " + user.getFirstName() + " " + user.getLastName() +
                    "\n Тур, " + tour.getNameRu() + ", цена " + tour.getPrice() + " тг" +
                    "\n Дополнительная услуга, " + service.getNameRu() + ", цена " + service.getPrice() + " тг" +
                    "\n Общая сумма, " + totalAmount + " тг.");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
