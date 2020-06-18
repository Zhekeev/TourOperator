package action.impl.adminAction;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.IMPLConstants.EDIT_USER_BY_ADMIN;
import static constant.IMPLConstants.ID;

public class EditUserByAdminButton implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        request.getSession().setAttribute(ID, request.getParameter(ID));
        request.getRequestDispatcher(EDIT_USER_BY_ADMIN).forward(request,response);
    }
}
