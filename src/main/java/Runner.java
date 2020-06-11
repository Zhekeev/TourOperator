import businesslogic.DataManipulation;
import connection.ConnectionPoolException;
import entity.Tour;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Runner {
    static HttpServletRequest request;
    public static void main(String[] args) throws ConnectionPoolException {
        DataManipulation dataManipulation = new DataManipulation();
        System.out.println(dataManipulation.calculateAllPrice(1,1));
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Tour tour = (Tour) session.getAttribute("tour");
        int idClient = user.getId();
        int idTour = tour.getId();
        System.out.println(idClient);
    }
}
