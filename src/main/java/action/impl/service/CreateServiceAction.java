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

import static constant.IMPLConstants.*;

public class CreateServiceAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        Service service = new Service();
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        String name = request.getParameter(NAME);
        String description = request.getParameter(DESCRIPTION);
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(request.getParameter(PRICE)));

        if(name.isEmpty() || description.isEmpty() || price == null){
            request.setAttribute("message", "Пустые поля");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        service.setNameRu(name);
        service.setDescriptionRu(description);
        service.setPrice(price);
        serviceDao.create(service);

        request.getRequestDispatcher(SHOW_COUNTRY_LIST_ADMIN).forward(request, response);
    }
}
