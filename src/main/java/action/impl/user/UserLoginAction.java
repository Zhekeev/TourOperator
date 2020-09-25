package action.impl.user;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;
import role.Role;
import service.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constant.ErrorConstant.*;
import static constant.IMPLConstants.*;


public class UserLoginAction implements Action {
    private HashPassword hashPassword = new HashPassword();
    private UserDaoImpl clientDao = new UserDaoImpl();
    private HttpSession session;
    private String login;
    private String password;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {

        User user = new User();
        session = request.getSession();
        login = request.getParameter(LOGIN);
        password = request.getParameter(PASSWORD);
        password = hashPassword.getHashPassword(password);
        user.setLogin(login);
        user.setPassword(password);

        if (login.isEmpty() || password.isEmpty()) {
            request.setAttribute(MESSAGE, DATA_EMPTY);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        user = clientDao.getClientByLoginAndPassword(login,password);

        if(user !=null && !user.getAdmin()){
            session.setAttribute(USER, user);
            session.setAttribute(ROLE, Role.CLIENT);
            request.getRequestDispatcher(HOME_PAGE_URL).forward(request, response);

        } else if (user!=null && user.getAdmin()) {
            session.setAttribute(USER, user);
            session.setAttribute(ROLE, Role.ADMIN);
            request.getRequestDispatcher(HOME_PAGE_URL).forward(request, response);
        } else {
            request.setAttribute(MESSAGE, ERROR_USER);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}

