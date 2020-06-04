package action.impl.service;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ServiceDaoImpl;
import entity.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static action.impl.IMPLConstants.ERROR_URL;
import static action.impl.IMPLConstants.ID;

public class DeleteServiceAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        int id = Integer.parseInt(request.getParameter(ID));
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        Service service = serviceDao.getByID(id);

        if(service!=null){
            serviceDao.delete(id);
            new ShowServiceList().execute(request,response);
        }else {
            request.setAttribute("message", "Тура не существует.");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
