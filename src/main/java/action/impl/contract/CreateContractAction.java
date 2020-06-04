package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.Contract;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static action.impl.IMPLConstants.ID;

public class CreateContractAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        Contract contract = new Contract();
        ContractDaoImpl contractDao = new ContractDaoImpl();

        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));

/*        contract.setIdClient();*/
    }
}
