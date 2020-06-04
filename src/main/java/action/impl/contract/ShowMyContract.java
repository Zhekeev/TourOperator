package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class ShowMyContract implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
 /*       ContractDaoImpl contractDao = new ContractDaoImpl();
        Contract contract = contractDao.getByID(id);
        request.setAttribute("my_contract", contract);
        request.getRequestDispatcher(SHOW_SERVICE_LIST_ADMIN_URL).forward(request, response);*/
    }
}
