package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class FinalContract implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        ContractDaoImpl contractDao = new ContractDaoImpl();

    }
}
