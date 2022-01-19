import exceptions.BadParamException;
import exceptions.NullParamException;

public class TravelManager {

    public static void main(String[] args) throws NullParamException, BadParamException {
        //System.out.println("Hello World");

        Airport Ohare = new Airport("ORD");
        Airport Laguardia = new Airport("LGA");
        Airline Blue = new Airline("Jet Blue");
        Flight flight12345 = new Flight(Blue, Ohare, Laguardia);

        System.out.println("Printing Flight Data: \n" + flight12345.toString());

    }
}

