package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.Contract;
import entity.Tour;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import static constant.IMPLConstants.*;

public class TourContract implements Action {
    private HttpSession httpSession;
    private ContractDaoImpl contractDao = new ContractDaoImpl();
    private Contract contract = new Contract();
    private User user;
    private Tour tour;
    private Integer idTour;
    private Integer idClient;
    private Integer idContract;
    private Date tourStartDate;
    private Date tourFinishDate;
    private static final String CONTRACT = "contract";
    private static final String ID_TOUR = "idTour";
    private static final String ID_CONTRACT = "idContract";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        httpSession = request.getSession();
        user = (User) httpSession.getAttribute(USER);
        tour = (Tour) httpSession.getAttribute(TOUR);
        idTour = Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        idClient = user.getId();
        tourStartDate = Date.valueOf(request.getParameter(TOUR_START_DATE));
        tourFinishDate = Date.valueOf(tourStartDate.toLocalDate().plusDays(tour.getDuration()));

        contract.setIdClient(idClient);
        contract.setIdTour(idTour);
        contract.setTourStartDate(tourStartDate);
        contract.setTourFinishDate(tourFinishDate);
        contractDao.create(contract);
        idContract = contractDao.idService(idClient,idTour,tourStartDate,tourFinishDate);

        httpSession.setAttribute(ID_TOUR,idTour);
        httpSession.setAttribute(CONTRACT, contract);
        httpSession.setAttribute(ID_CONTRACT,idContract);
        request.getRequestDispatcher(FINAL_CONTRACT).forward(request,response);
    }
}
