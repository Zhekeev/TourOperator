package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static constant.IMPLConstants.SHOW_TOUR_LIST_ADMIN_URL;

public class ShowTourListByCountry implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        request.getSession().setAttribute("id", request.getParameter("id"));
        Integer id = Integer.valueOf(request.getParameter("id"));
        TourDaoImpl tourDao = new TourDaoImpl();
        List<Tour> tourList = tourDao.getAllbyCountry(id);
        request.setAttribute("tour_list", tourList);
        request.getRequestDispatcher(SHOW_TOUR_LIST_ADMIN_URL).forward(request, response);
    }
}
