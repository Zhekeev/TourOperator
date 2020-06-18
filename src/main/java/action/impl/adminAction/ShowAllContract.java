package action.impl.adminAction;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.dto.ContractDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static constant.IMPLConstants.SHOW_ALL_CONTRACT_URL;

public class ShowAllContract implements Action {
    private ContractDaoImpl contractDao = new ContractDaoImpl();
    private List<ContractDTO> contractDtos;
    private static final String CONTRACT_LIST = "contract_list";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        contractDtos = contractDao.getAllInfo();
        request.setAttribute(CONTRACT_LIST, contractDtos);
        request.getRequestDispatcher(SHOW_ALL_CONTRACT_URL).forward(request, response);
    }
}
