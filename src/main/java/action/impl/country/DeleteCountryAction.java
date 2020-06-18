package action.impl.country;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.CountryDaoImpl;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.ErrorConstant.EMPTY_COUNTRY;
import static constant.ErrorConstant.MESSAGE;
import static constant.IMPLConstants.ERROR_URL;
import static constant.IMPLConstants.ID;

public class DeleteCountryAction implements Action {
    private CountryDaoImpl countryDao = new CountryDaoImpl();
    private Country country;
    private Integer id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        id = Integer.parseInt(request.getParameter(ID));
        country = countryDao.getByID(id);

        if (country != null) {
            countryDao.delete(id);
            new ShowCountryList().execute(request, response);
        } else {
            request.setAttribute(MESSAGE, EMPTY_COUNTRY);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }
    }
}
