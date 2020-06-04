package action.impl.service;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.ServiceDaoImpl;
import entity.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

import static action.impl.IMPLConstants.*;

public class UpdateServiceAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        Service service = new Service();
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        String name = request.getParameter(NAME);
        String description = request.getParameter(DESCRIPTION);
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(request.getParameter(PRICE)));

        if(name.isEmpty() || description.isEmpty() || price == null){
            request.setAttribute("message", "Пустые поля");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        service.setName(name);
        service.setDescription(description);
        service.setPrice(price);
        serviceDao.update(id,service);

        request.getRequestDispatcher(SHOW_SERVICE_LIST_ADMIN).forward(request, response);
    }
}
