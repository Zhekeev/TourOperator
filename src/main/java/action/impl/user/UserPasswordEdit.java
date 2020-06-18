package action.impl.user;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;
import service.HashPassword;
import validator.PasswordValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static constant.ErrorConstant.*;
import static constant.IMPLConstants.*;

public class UserPasswordEdit implements Action {
    private HttpSession session;
    private HashPassword hashPassword = new HashPassword();
    private UserDaoImpl userDao = new UserDaoImpl();
    private User user;
    private String password;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        session = request.getSession();
        user = (User) session.getAttribute(USER);
        password = request.getParameter(PASSWORD);

        if(!new PasswordValidator().passwordValidator(password)){
            request.setAttribute(MESSAGE,CHECK_PASSWORD);
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }
        if (password.isEmpty()){
            request.setAttribute(MESSAGE,DATA_EMPTY);
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }

        password = hashPassword.getHashPassword(password);
        user.setPassword(password);
        userDao.updatePassword(user.getId(), user);
        request.getRequestDispatcher(HOME_PAGE_URL).forward(request, response);
    }
}
