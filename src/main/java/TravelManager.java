import exceptions.BadParamException;
import exceptions.NullParamException;

public class TravelManager {

    public static void main(String[] args) throws NullParamException, BadParamException {
        //System.out.println("Hello World");

        Airport Ohare = new Airport("ORD");
        Airport Laguardia = new Airport("LGA");
        Airline Blue = new Airline("Jet Blue");
       // CommercialFlight commercialFlight12345 = new CommercialFlight(Blue, Ohare, Laguardia);
        FlightManagerProxy flightManager = new FlightManagerProxy();
        flightManager.createFlight("CommercialFlight",Blue, Ohare, Laguardia);
        flightManager.createFlight("PassengerFlight", new Airline("American"),new Airport("LAX"),new Airport("JFK"), 60);



        System.out.println("Printing CommercialFlight Data: \n" + flightManager.toString());
        System.out.println("Printing PassengerFlight Data: \n" + flightManager.toString());

    }
}

