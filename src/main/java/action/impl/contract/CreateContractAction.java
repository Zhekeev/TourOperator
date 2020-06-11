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

public class CreateContractAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        Tour tour = (Tour) session.getAttribute("tour");
        User client = (User) session.getAttribute("user");
        Contract contract = new Contract();
        ContractDaoImpl contractDao = new ContractDaoImpl();
        Date tourStartDate = (Date) session.getAttribute("tourStartDate");
        Date tourFinishDate = (Date) session.getAttribute("tourFinishDate");
        contract.setIdClient(client.getId());
        contract.setIdTour(tour.getId());
        contract.setTourStartDate(tourStartDate);
        contract.setTourFinishDate(tourFinishDate);
        contractDao.create(contract);
        session.setAttribute("contract",contract);
    }
}
