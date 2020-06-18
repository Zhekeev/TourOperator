package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.ErrorConstant.EMPTY_TOUR;
import static constant.ErrorConstant.MESSAGE;
import static constant.IMPLConstants.ERROR_URL;
import static constant.IMPLConstants.ID;

public class DeleteTourAction implements Action {
    private TourDaoImpl tourDao = new TourDaoImpl();
    private Tour tour;
    private Integer id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        id = Integer.parseInt(request.getParameter(ID));
        tour = tourDao.getByID(id);

        if(tour!=null){
            tourDao.delete(id);
            new ShowTourList().execute(request,response);
        }else {
            request.setAttribute(MESSAGE, EMPTY_TOUR);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
