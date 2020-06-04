package action.impl.user;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static action.impl.IMPLConstants.USER;

public class DeleteUserAction implements Action {
    private UserDaoImpl userDao;
    private User user;
    private int id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        HttpSession session = request.getSession();
        user = (User) session.getAttribute(USER);
        userDao.delete(user.getId());
    }
}
