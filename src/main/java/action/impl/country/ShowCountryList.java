package action.impl.country;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.CountryDaoImpl;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static action.impl.IMPLConstants.SHOW_COUNTRY_LIST_ADMIN_URL;

public class ShowCountryList implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        CountryDaoImpl countryDao = new CountryDaoImpl();
        List<Country> countries = countryDao.getAll();
        request.setAttribute("country_list", countries);
        request.getRequestDispatcher(SHOW_COUNTRY_LIST_ADMIN_URL).forward(request, response);
    }
}
