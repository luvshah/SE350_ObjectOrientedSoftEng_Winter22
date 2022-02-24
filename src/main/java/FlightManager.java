import exceptions.BadParamException;
import exceptions.NullParamException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class FlightManager extends FlightFactory{

    private List<Flight> flights;
    private static FlightManager instanceOfThis = null;

    public static FlightManager getInstance()throws Exception
    {
        if(instanceOfThis == null)
        {
            instanceOfThis = new FlightManager();
        }
        return instanceOfThis;
    }
    private FlightManager(){ flights = new ArrayList();}

    public Flight createFlight(String type, Airline liner, Airport origin, Airport dest)
    {
        try {
            flights.add(super.createFlight(type, liner, origin,dest, 0));
        } catch (NullParamException | BadParamException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Flight createFlight(String type, Airline liner, Airport origin, Airport dest, int size)
    {
        try {
            flights.add(super.createFlight(type, liner, origin,dest, size));
        } catch (NullParamException | BadParamException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Flight getFlightByNumber(String flightnum)throws BadParamException{

        for(Flight flight : flights){
            if(flightnum.equals(flight.getFlightNumber()))
                return flight;
        }
        throw new BadParamException("Bad parameter in getFlightNumber(String)");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!flights.isEmpty()) {
            for(Flight it : flights)
            {
                sb.append(it.toString());
            }

        }
        return sb.toString();
    }
    @Override
    public int hashCode() {
        return Objects.hash(instanceOfThis, flights);
    }
}
