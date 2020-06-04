package action.impl.country;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.CountryDaoImpl;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static action.impl.IMPLConstants.*;

public class UpdateCountryAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        Country country = new Country();
        CountryDaoImpl countryDao = new CountryDaoImpl();

        int id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        String nameRu = request.getParameter(NAME_RU);
        String nameEng = request.getParameter(NAME_ENG);
        Integer idImage = Integer.parseInt(request.getParameter(ID_IMAGE));

        if(nameRu.isEmpty() || nameEng.isEmpty() || idImage == null){
            request.setAttribute("message", "Пустые поля");
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        country.setNameRu(nameRu);
        country.setNameEng(nameEng);
        country.setIdImage(idImage);
        countryDao.update(id, country);

        request.getRequestDispatcher(SHOW_COUNTRY_LIST_ADMIN).forward(request, response);
    }
}
