package businesslogic;

import connection.ConnectionPoolException;
import dao.impl.ServiceDaoImpl;
import dao.impl.TourDaoImpl;
import entity.Service;
import entity.Tour;
import org.apache.log4j.Logger;

import java.math.BigDecimal;

public class DataManipulation {
    private static final Logger logger = Logger.getLogger(DataManipulation.class);

    public BigDecimal calculateTourPrice(int id) throws ConnectionPoolException {
        TourDaoImpl tourDao = new TourDaoImpl();
        Tour tour = tourDao.getByID(id);
        BigDecimal tourPrice = tour.getPrice();
        return tourPrice;
    }

    public BigDecimal calculateAllPrice(int idTour, int idService) throws ConnectionPoolException {
        TourDaoImpl tourDao = new TourDaoImpl();
        ServiceDaoImpl serviceDao = new ServiceDaoImpl();
        Tour tour = tourDao.getByID(idTour);
        Service service = serviceDao.getByID(idService);
        BigDecimal tourPrice = tour.getPrice();
        BigDecimal servicePrice = service.getPrice();
        BigDecimal finalPrice = tourPrice.add(servicePrice);
        return finalPrice;
    }
}
