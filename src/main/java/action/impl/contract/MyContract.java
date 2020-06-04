package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.Contract;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import static action.impl.IMPLConstants.ID;
import static action.impl.IMPLConstants.USER;

public class MyContract implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute(USER);
        int idTour = Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        int idClient = user.getId();
        Date tourStartDate = Date.valueOf(request.getParameter("tourStartDate"));
        Date tourFinishDate = Date.valueOf(request.getParameter("tourFinishDate"));
        ContractDaoImpl contractDao = new ContractDaoImpl();
        Contract contract = new Contract();
        contract.setIdClient(idClient);
        contract.setIdTour(idTour);
        contract.setTourStartDate(tourStartDate);
        contract.setTourFinishDate(tourFinishDate);
        contractDao.create(contract);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
