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

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.MY_CONTRACT_URL;

public class MyContractButton implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        HttpSession session = request.getSession();
        request.getSession().setAttribute(ID, request.getParameter(ID));
        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        TourDaoImpl tourDao = new TourDaoImpl();
        Tour tour = tourDao.getByID(id);
        session.setAttribute("tour",tour);
        request.setAttribute("tour_list", tour);
        request.getRequestDispatcher(MY_CONTRACT_URL).forward(request,response);
    }
}
