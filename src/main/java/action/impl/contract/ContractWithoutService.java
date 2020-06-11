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
import java.time.LocalDate;

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.USER;

public class ContractWithoutService implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(USER);
        Tour tour = (Tour) httpSession.getAttribute("tour");
        int idTour = Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        int idClient = user.getId();
        Date tourStartDate = Date.valueOf(request.getParameter("tourStartDate"));
        Date tourFinishDate = Date.valueOf(request.getParameter("tourFinishDate"));
        ContractDaoImpl contractDao = new ContractDaoImpl();
        LocalDate localDate = tourStartDate.toLocalDate();
        System.out.println("*/*/*/*/*/*/*/*/*/*/*/*/*/*/*");
        System.out.println(localDate.plusDays(tour.getDuration()));
        Contract contract = new Contract();
        contract.setIdClient(idClient);
        contract.setIdTour(idTour);
        contract.setTourStartDate(tourStartDate);
        contract.setTourFinishDate(tourFinishDate);
        contractDao.create(contract);
        int idContract = contractDao.idService(idClient,idTour,tourStartDate,tourFinishDate);
        httpSession.setAttribute("idTour",idTour);
        httpSession.setAttribute("contract", contract);
        httpSession.setAttribute("idContract",idContract);
        request.getRequestDispatcher("/final_contract").forward(request,response);
    }
}
