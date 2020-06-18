package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import static constant.IMPLConstants.*;

public class CreateContractAction implements Action {
   private Tour tour;
   private User user;
   private Contract contract = new Contract();
   private ContractDaoImpl contractDao = new ContractDaoImpl();
   private  Date tourStartDate;
   private  Date tourFinishDate;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        tour = (Tour) session.getAttribute(TOUR);
        user = (User) session.getAttribute(USER);

        tourStartDate = (Date) session.getAttribute(TOUR_START_DATE);
        tourFinishDate = (Date) session.getAttribute(TOUR_FINISH_DATE);

        contract.setIdClient(user.getId());
        contract.setIdTour(tour.getId());
        contract.setTourStartDate(tourStartDate);
        contract.setTourFinishDate(tourFinishDate);
        contractDao.create(contract);

        session.setAttribute(CONTRACT,contract);
    }
}
