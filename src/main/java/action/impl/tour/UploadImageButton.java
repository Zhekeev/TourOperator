package action.impl.tour;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.UPLOAD_IMAGE_URL;

public class UploadImageButton implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        request.getSession().setAttribute(ID, request.getParameter(ID));
        request.getRequestDispatcher(UPLOAD_IMAGE_URL).forward(request, response);
    }
}
