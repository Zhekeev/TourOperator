package action.impl.user;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;
import service.HashPassword;
import validator.PasswordValidator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static action.impl.IMPLConstants.*;

public class UserPasswordEdit implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        HttpSession session = request.getSession();
        HashPassword hashPassword = new HashPassword();
        User user = (User) session.getAttribute(USER);
        UserDaoImpl clientDao = new UserDaoImpl();
        String password = request.getParameter(PASSWORD);

        if(!new PasswordValidator().passwordValidator(password)){
            request.setAttribute("message","Ошибка,  проверте свой пароль");
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }
        if (password.isEmpty()){
            request.setAttribute("message","Ошибка,  поле пустое");
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }

        password = hashPassword.getHashPassword(password);
        user.setPassword(password);
        clientDao.updatePassword(user.getId(), user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(HOME_PAGE_URL);
        requestDispatcher.forward(request, response);
    }
}
