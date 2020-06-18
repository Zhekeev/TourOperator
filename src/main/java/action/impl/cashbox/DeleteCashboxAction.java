package action.impl.cashbox;

import action.Action;
import connection.ConnectionPoolException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

public class DeleteCashboxAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException, ParseException {

    }
}
