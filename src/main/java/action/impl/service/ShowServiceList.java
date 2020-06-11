package action.impl.service;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ServiceDaoImpl;
import entity.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constant.IMPLConstants.SHOW_SERVICE_LIST_ADMIN_URL;

public class ShowServiceList implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {

        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        List<Service> services = serviceDao.getAll();
        request.setAttribute("my_contract", services);
        request.getRequestDispatcher(SHOW_SERVICE_LIST_ADMIN_URL).forward(request, response);
    }
}
