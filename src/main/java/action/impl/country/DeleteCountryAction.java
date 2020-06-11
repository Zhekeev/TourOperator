package action.impl.country;

import action.Action;
import action.impl.adminAction.ShowUserList;
import connection.ConnectionPoolException;
import dao.impl.CountryDaoImpl;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.IMPLConstants.ERROR_URL;

public class DeleteCountryAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        int id = Integer.parseInt(request.getParameter("id"));
        CountryDaoImpl countryDao = new CountryDaoImpl();
        Country country = countryDao.getByID(id);
        if (country != null) {
            countryDao.delete(id);
            new ShowUserList().execute(request, response);
        } else {
            request.setAttribute("message", "Страны не существует.");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
