package action.impl.adminAction;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteUserByAdmin implements Action{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDaoImpl userDao = new UserDaoImpl();
        User user = userDao.getByID(id);

        if(user!=null){
            userDao.delete(id);
            new ShowUserList().execute(request,response);
        }else {
            request.setAttribute("message", "Тура не существует.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

