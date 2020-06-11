package action.impl.contract;

import action.Action;
import businesslogic.DataManipulation;
import connection.ConnectionPoolException;
import dao.impl.ServiceDaoImpl;
import dao.impl.TourDaoImpl;
import entity.Tour;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

public class FinalContractButton implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        DataManipulation dataManipulation = new DataManipulation();
      /*  request.getSession().setAttribute(ID, request.getParameter(ID));
        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));*/
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        TourDaoImpl tourDao = new TourDaoImpl();
        Tour tour = (Tour) session.getAttribute("tour");
/*        Service service = serviceDao.getByID(id);*/
        int idTour = tour.getId();
/*        request.setAttribute("services", service);*/
        request.setAttribute("tours",tourDao.getByID(idTour));
     /*   if(service == null){
            BigDecimal priceTour = dataManipulation.calculateTourPrice(idTour);
        }*/
        BigDecimal price = dataManipulation.calculateTourPrice(idTour);
        session.setAttribute("price", price);
        request.setAttribute("price", price);
/*        session.setAttribute("service",service);*/
        request.getRequestDispatcher("/finalcontract.jsp").forward(request,response);
    }
}
