package action.impl.country;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.CountryDaoImpl;
import entity.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constant.ErrorConstant.DATA_EMPTY;
import static constant.ErrorConstant.MESSAGE;
import static constant.IMPLConstants.*;

public class UpdateCountryAction implements Action {
    private Country country = new Country();
    private CountryDaoImpl countryDao = new CountryDaoImpl();
    private String nameRu;
    private String nameEng;
    private Integer id;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        id =Integer.parseInt(String.valueOf(request.getSession().getAttribute(ID)));
        nameRu = request.getParameter(NAME_RU);
        nameEng = request.getParameter(NAME_ENG);

        if(nameRu.isEmpty() || nameEng.isEmpty()){
            request.setAttribute(MESSAGE, DATA_EMPTY);
            request.getRequestDispatcher(ERROR_URL).forward(request, response);
        }

        country.setNameRu(nameRu);
        country.setNameEng(nameEng);
        countryDao.update(id, country);

        request.getRequestDispatcher(SHOW_COUNTRY).forward(request, response);
    }
}
