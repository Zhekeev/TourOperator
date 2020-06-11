package action.impl.servicecontract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ServiceContractDaoImpl;
import entity.Service;
import entity.ServiceContract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

public class CreateServiceContractAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        Service service = (Service) session.getAttribute("service");
        //Contract contract = (Contract) session.getAttribute("contract");
        int idContract = (int) session.getAttribute("idContract");
        ServiceContract serviceContract = new ServiceContract();
        ServiceContractDaoImpl serviceContractDao = new ServiceContractDaoImpl();
        serviceContract.setIdService(service.getId());
        serviceContract.setIdContract(idContract);
        serviceContractDao.create(serviceContract);
    }
}
