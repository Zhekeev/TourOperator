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

import static constant.IMPLConstants.SHOW_USER_LIST_URL;
import static constant.IMPLConstants.USER_LIST;

public class ShowUserList implements Action {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        List<User> userList = userDao.getAll();
        request.setAttribute(USER_LIST, userList);
        request.getRequestDispatcher(SHOW_USER_LIST_URL).forward(request, response);
    }
}
