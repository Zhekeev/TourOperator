package action.impl.contract;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ContractDaoImpl;
import entity.dto.ContractDTO;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import static constant.IMPLConstants.SHOW_SERVICE_LIST_ADMIN_URL;
import static constant.IMPLConstants.USER;

public class ShowMyContract implements Action {
    private ContractDaoImpl contractDao = new ContractDaoImpl();
    private User user;
    private List <ContractDTO> contractDto;
    private Integer idUser;
    public static final String MY_CONTRACT = "my_contract";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        HttpSession session = request.getSession();

        user = (User) session.getAttribute(USER);
        idUser = user.getId();
        contractDto = contractDao.getInfoById(idUser);

        request.setAttribute(MY_CONTRACT, contractDto);

        request.getRequestDispatcher(SHOW_SERVICE_LIST_ADMIN_URL).forward(request, response);
    }
}
