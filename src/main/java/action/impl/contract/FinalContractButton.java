package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

import static constant.IMPLConstants.*;

public class FinalContractButton implements Action {
    private TourDaoImpl tourDao = new TourDaoImpl();
    private Tour tour;
    private Integer idTour;
    private BigDecimal price;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        tour = (Tour) session.getAttribute(TOUR);
        idTour = tour.getId();
        price = tour.getPrice();

        request.setAttribute(TOUR,tourDao.getByID(idTour));
        session.setAttribute(PRICE, price);
        request.setAttribute(PRICE, price);

        request.getRequestDispatcher(CASHBOX_URL).forward(request,response);
    }
}
