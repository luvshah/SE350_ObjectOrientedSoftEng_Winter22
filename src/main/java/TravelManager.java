import exceptions.BadParamException;
import exceptions.NullParamException;

public class TravelManager {

    public static void main(String[] args) throws NullParamException, BadParamException {
        //System.out.println("Hello World");

        Airport Ohare = new Airport("ORD");
        Airport Laguardia = new Airport("LGA");
        Airline Blue = new Airline("Jet Blue");
       // CommercialFlight commercialFlight12345 = new CommercialFlight(Blue, Ohare, Laguardia);
        FlightManager flightManager = null;
        try {
            flightManager = FlightManager.getInstance();
            flightManager.createFlight("CommercialFlight",Blue, Ohare, Laguardia);
        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("Printing CommercialFlight Data: \n" + flightManager.toString());

    }
}

