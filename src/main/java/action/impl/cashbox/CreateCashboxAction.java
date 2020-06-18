package action.impl.cashbox;

import action.Action;
import action.impl.contract.CreateContractAction;
import service.SendMail;
import connection.ConnectionPoolException;
import dao.impl.CashboxDaoImpl;
import entity.Cashbox;
import entity.Tour;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static constant.IMPLConstants.*;

public class CreateCashboxAction implements Action {
    private CreateContractAction createContractAction = new CreateContractAction();
    private SendMail sendMail = new SendMail();
    private Cashbox cashbox = new Cashbox();
    private CashboxDaoImpl cashboxDao = new CashboxDaoImpl();
    private User user ;
    private Tour tour ;
    private BigDecimal price;
    private int idClient;
    private int idTour;
    private static final String DATE_FORMAT = "yyyy.MM.dd 'at' HH:mm:ss";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);

        user = (User) session.getAttribute(USER);
        tour = (Tour) session.getAttribute(TOUR);
        price = (BigDecimal) session.getAttribute(PRICE);

        idClient = user.getId();
        idTour = tour.getId();

        cashbox.setIdClient(idClient);
        cashbox.setIdTour(idTour);
        cashbox.setAmount(price);
        cashbox.setDate(simpleDateFormat.format(new java.util.Date()));
        cashboxDao.create(cashbox);
        createContractAction.execute(request,response);
        sendMail.execute(request,response);

        request.getRequestDispatcher(HOME_PAGE_URL).forward(request, response);
    }
}
