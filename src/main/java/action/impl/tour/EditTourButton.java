package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditTourButton implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        request.getSession().setAttribute("id", request.getParameter("id"));
        request.getRequestDispatcher("/edit_tour.jsp").forward(request,response);
    }
}
