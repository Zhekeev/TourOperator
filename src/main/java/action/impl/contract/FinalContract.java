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
import java.text.ParseException;

import static constant.IMPLConstants.MY_CONTRACT_URL;

public class FinalContract implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();
        ContractDaoImpl contractDao = new ContractDaoImpl();
        User user = (User) session.getAttribute("user");
        Contract contract = contractDao.getByID(user.getId());
        request.setAttribute("contract", contract);
        request.getRequestDispatcher(MY_CONTRACT_URL).forward(request,response);
    }
}
