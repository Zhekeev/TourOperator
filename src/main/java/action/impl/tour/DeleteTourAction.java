package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteTourAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {

        int id = Integer.parseInt(request.getParameter("id"));
        TourDaoImpl tourDao = new TourDaoImpl();
        Tour tour = tourDao.getByID(id);

        if(tour!=null){
            tourDao.delete(id);
            new ShowTourList().execute(request,response);
        }else {
            request.setAttribute("message", "Тура не существует.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
