package action.impl.adminAction;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constant.IMPLConstants.SHOW_USER_LIST_ADMIN_URL;

public class ShowUserList implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> userList = userDao.getAll();
        request.setAttribute("userList", userList);
        request.getRequestDispatcher(SHOW_USER_LIST_ADMIN_URL).forward(request, response);
    }
}
