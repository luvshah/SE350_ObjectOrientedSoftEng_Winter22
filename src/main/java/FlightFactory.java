import exceptions.BadParamException;
import exceptions.NullParamException;

import java.util.HashMap;

public class FlightFactory {

    private HashMap<Airline, Flight> flightCache = new HashMap<>();

    public Flight createFlight(String type, Airline liner, Airport origin, Airport dest, int size) throws NullParamException, BadParamException {
        if(type.equals("CommercialFlight"))
            //return new CommercialFlight(liner, origin,dest);
        {
            Flight newFlight = flightCache.get(liner);
            if(newFlight == null)
            {
                flightCache.put(liner, new CommercialFlight(liner, origin, dest));
                return flightCache.get(liner);
            }
                return newFlight;
        }
        if(type.equals("PassengerFlight"))
            //return new PassengerFlight(liner, origin, dest, size);
        {
            Flight newFlight = flightCache.get(liner);
            if(newFlight == null)
            {
                flightCache.put(liner, new PassengerFlight(liner, origin, dest,size));
                return flightCache.get(liner);
            }
            return newFlight;
        }
        else return null;
    }
}
