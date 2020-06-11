package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import dao.impl.ServiceContractDaoImpl;
import entity.Contract;
import entity.ServiceContract;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.USER;

public class ContractWithService implements Action {
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
        int idContract = contractDao.idService(idClient,idTour,tourStartDate,tourFinishDate);
        httpSession.setAttribute("contract", contract);
        httpSession.setAttribute("idContract",idContract);

        ServiceContractDaoImpl serviceContractDao = new ServiceContractDaoImpl();
        ServiceContract serviceContract = new ServiceContract();
     /*   serviceContractDao.create();*/
    }
}
