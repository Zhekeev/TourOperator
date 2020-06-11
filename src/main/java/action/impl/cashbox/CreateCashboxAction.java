package action.impl.cashbox;

import action.Action;
import action.impl.contract.CreateContractAction;
import action.impl.servicecontract.CreateServiceContractAction;
import businesslogic.SendMail;
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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static constant.IMPLConstants.HOME_PAGE_URL;

public class CreateCashboxAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        CreateContractAction createContractAction = new CreateContractAction();
        CreateServiceContractAction createServiceContractAction = new CreateServiceContractAction();
        java.util.Date uDate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        User user = (User) session.getAttribute("user");
        Tour tour = (Tour) session.getAttribute("tour");
        BigDecimal price = (BigDecimal) session.getAttribute("price");
        SendMail sendMail = new SendMail();
        int idClient = user.getId();
        int idTour = tour.getId();
        Cashbox cashbox = new Cashbox();
        CashboxDaoImpl cashboxDao = new CashboxDaoImpl();
        cashbox.setIdClient(idClient);
        cashbox.setIdTour(idTour);
        cashbox.setAmount(price);
        cashbox.setDate(simpleDateFormat.format(new java.util.Date()));
        cashboxDao.create(cashbox);
        createContractAction.execute(request,response);
        createServiceContractAction.execute(request,response);
        sendMail.execute(request,response);
        request.getRequestDispatcher(HOME_PAGE_URL).forward(request, response);
    }
    private Date convert(java.util.Date uDate){
        Date date = new Date(uDate.getTime());
        return date;
    }
}
