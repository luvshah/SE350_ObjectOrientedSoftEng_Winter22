import exceptions.NullParamException;

public class FlightFactory {

    public Flight createFlight(String type, Airline liner, Airport origin, Airport dest) throws NullParamException {
        if(type.equals("CommercialFlight"))
            return new CommercialFlight(liner, origin,dest);
        else return null;
    }
}
