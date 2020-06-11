package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static constant.IMPLConstants.*;

public class UpdateTourAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        TourDaoImpl tourDao = new TourDaoImpl();
        Tour tour = new Tour();

        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        String nameRu = request.getParameter(NAME_RU);
        String nameEng = request.getParameter(NAME_ENG);
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(request.getParameter(PRICE)));
        Integer duration = Integer.parseInt(request.getParameter(DURATION));
        String descriptionRu = request.getParameter(DESCRIPTION_RU);
        String descriptionEng = request.getParameter(DESCRIPTION_ENG);

        if(nameRu.isEmpty() || nameEng.isEmpty() || price == null || duration == null
                || descriptionRu.isEmpty() || descriptionEng.isEmpty()){
            request.setAttribute("message", "Пустые поля");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        tour.setNameRu(nameRu);
        tour.setNameEng(nameEng);
        tour.setPrice(price);
        tour.setDuration(duration);
        tour.setDescriptionRu(descriptionRu);
        tour.setDescriptionEng(descriptionEng);
        //tour.setIdImage(idImage);
        tourDao.update(id,tour);

        new ShowTourList().execute(request,response);
    }
}
