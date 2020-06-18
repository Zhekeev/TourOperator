package service;

import action.Action;
import connection.ConnectionPool;
import connection.ConnectionPoolException;
import entity.Tour;
import entity.User;
import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Properties;

public class SendMail implements Action {
    private Properties properties = getProperties("email.properties");
    private static final Logger LOGGER = Logger.getLogger(SendMail.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");
        Tour tour = (Tour) httpSession.getAttribute("tour");
        BigDecimal totalAmount = (BigDecimal) httpSession.getAttribute("price");
        String clientEmail = user.getEmail();

        final String username = properties.getProperty("email");
        final String password = properties.getProperty("password");

        String from = properties.getProperty("email");
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
                    "\n Общая сумма, " + totalAmount + " тг.");
            Transport.send(message);
        } catch (MessagingException e) {
            LOGGER.error(e);
        }
    }

    private Properties getProperties(String configurationFile) {
        Properties properties = new Properties();
        InputStream inputStream = ConnectionPool.class.getClassLoader().getResourceAsStream(configurationFile);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            LOGGER.error(e);
        }
        return properties;
    }
}
