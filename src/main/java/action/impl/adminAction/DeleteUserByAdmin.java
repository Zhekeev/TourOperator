package action.impl.adminAction;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.ErrorConstant.EMPTY_USER;
import static constant.ErrorConstant.MESSAGE;
import static constant.IMPLConstants.ERROR_URL;
import static constant.IMPLConstants.ID;

public class DeleteUserByAdmin implements Action{
    private UserDaoImpl userDao = new UserDaoImpl();
    private User user;
    private Integer id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        id = Integer.parseInt(request.getParameter(ID));
        user = userDao.getByID(id);

        if(user!=null){
            userDao.delete(id);
            new ShowUserList().execute(request,response);
        }else {
            request.setAttribute(MESSAGE, EMPTY_USER);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}

