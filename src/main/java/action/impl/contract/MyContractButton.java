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

import static constant.IMPLConstants.*;

public class MyContractButton implements Action {
    private HttpSession session;
    private TourDaoImpl tourDao = new TourDaoImpl();
    private Tour tour;
    private Integer idTour;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        session = request.getSession();
        request.getSession().setAttribute(ID, request.getParameter(ID));

        idTour =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        tour = tourDao.getByID(idTour);

        session.setAttribute(TOUR,tour);
        request.setAttribute(TOUR,tour);

        request.getRequestDispatcher(CONTRACT_URL).forward(request,response);
    }
}
