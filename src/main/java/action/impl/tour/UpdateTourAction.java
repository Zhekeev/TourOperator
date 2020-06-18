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

import static constant.ErrorConstant.DATA_EMPTY;
import static constant.ErrorConstant.MESSAGE;
import static constant.IMPLConstants.*;

public class UpdateTourAction implements Action {
    private TourDaoImpl tourDao = new TourDaoImpl();
    private Tour tour = new Tour();
    private int id;
    private String nameRu;
    private String nameEng;
    private BigDecimal price;
    private Integer duration;
    private String descriptionRu;
    private String descriptionEng;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        nameRu = request.getParameter(NAME_RU);
        nameEng = request.getParameter(NAME_ENG);
        price = BigDecimal.valueOf(Integer.parseInt(request.getParameter(PRICE)));
        duration = Integer.parseInt(request.getParameter(DURATION));
        descriptionRu = request.getParameter(DESCRIPTION_RU);
        descriptionEng = request.getParameter(DESCRIPTION_ENG);

        if(nameRu.isEmpty() || nameEng.isEmpty() || price == null || duration == null
                || descriptionRu.isEmpty() || descriptionEng.isEmpty()){
            request.setAttribute(MESSAGE, DATA_EMPTY);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        tour.setNameRu(nameRu);
        tour.setNameEng(nameEng);
        tour.setPrice(price);
        tour.setDuration(duration);
        tour.setDescriptionRu(descriptionRu);
        tour.setDescriptionEng(descriptionEng);
        tourDao.update(id,tour);

        new ShowTourList().execute(request,response);
    }
}
