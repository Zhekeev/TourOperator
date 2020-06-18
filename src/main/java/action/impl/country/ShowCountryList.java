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

import static constant.IMPLConstants.SHOW_COUNTRY_LIST_ADMIN_URL;

public class ShowCountryList implements Action {
    private CountryDaoImpl countryDao = new CountryDaoImpl();
    private List<Country> countries;
    private static final String COUNTRY_LIST = "country_list";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        countries = countryDao.getAll();
        request.setAttribute(COUNTRY_LIST, countries);
        request.getRequestDispatcher(SHOW_COUNTRY_LIST_ADMIN_URL).forward(request, response);
    }
}
