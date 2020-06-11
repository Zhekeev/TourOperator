package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

import static constant.IMPLConstants.HOME_PAGE_URL;

public class DeleteContractAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        Contract contract = (Contract) session.getAttribute("contract");
        ContractDaoImpl contractDao = new ContractDaoImpl();
        int id = contract.getId();
        contractDao.delete(id);
        request.getRequestDispatcher(HOME_PAGE_URL).forward(request,response);
    }
}
