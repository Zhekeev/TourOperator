import businesslogic.DataManipulation;
import connection.ConnectionPoolException;

public class Runner {
    public static void main(String[] args) throws ConnectionPoolException {
        DataManipulation dataManipulation = new DataManipulation();
        System.out.println(dataManipulation.calculateAllPrice(1,1));
    }
}
