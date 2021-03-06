package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

import static constant.IMPLConstants.HOME_PAGE_URL;
import static constant.IMPLConstants.ID;

public class DeleteContractAction implements Action {
    private ContractDaoImpl contractDao = new ContractDaoImpl();
    private Contract contract;
    private Integer idContract;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        idContract = Integer.parseInt(request.getParameter(ID));
        contractDao.delete(idContract);
        request.getRequestDispatcher(HOME_PAGE_URL).forward(request,response);
    }
}
