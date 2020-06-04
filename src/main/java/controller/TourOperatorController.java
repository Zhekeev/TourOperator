package controller;

import action.Action;
import action.ActionFactory;
import connection.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class TourOperatorController extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(TourOperatorController.class);
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            getAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
            getAction(req,resp);
    }

    private void getAction(HttpServletRequest request, HttpServletResponse response) {
        try {
            Action action = ActionFactory.getInstance().getAction(request);
            System.out.println(action.getClass());
            System.out.println("========================");
            action.execute(request,response);
        } catch (ServletException | IOException | ConnectionPoolException | ParseException e) {
            LOGGER.error(e);
        }
    }
}
