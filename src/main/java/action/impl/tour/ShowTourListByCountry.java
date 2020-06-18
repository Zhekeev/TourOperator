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

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.SHOW_TOUR_LIST_ADMIN_URL;

public class ShowTourListByCountry implements Action {
    private TourDaoImpl tourDao = new TourDaoImpl();
    private List<Tour> tours;
    private Integer id;
    private static final String TOUR_LIST = "tour_list";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        request.getSession().setAttribute(ID, request.getParameter(ID));
        id = Integer.valueOf(request.getParameter(ID));
        tours = tourDao.getAllbyCountry(id);
        request.setAttribute(TOUR_LIST, tours);
        request.getRequestDispatcher(SHOW_TOUR_LIST_ADMIN_URL).forward(request, response);
    }
}
