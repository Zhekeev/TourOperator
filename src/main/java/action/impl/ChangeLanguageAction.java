package action.impl;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

import static constant.IMPLConstants.ID;
import static constant.IMPLConstants.INDEX_URL;

public class ChangeLanguageAction implements Action {
    private HttpSession session;
    private static final String LANGUAGE = "language";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {
        session = request.getSession();
        String languageToChange =request.getParameter(ID);
        session.setAttribute(LANGUAGE,languageToChange);
        request.getRequestDispatcher(INDEX_URL).forward(request,response);
    }
}
