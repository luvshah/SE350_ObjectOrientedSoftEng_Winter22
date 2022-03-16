import exceptions.BadParamException;

public interface FlightManagerSubject {
    void createFlight(String type, Airline liner, Airport origin, Airport dest);
    Flight createFlight(String type, Airline liner, Airport origin, Airport dest, int size);
    Flight getFlightByNumber(String flightnum) throws BadParamException;
}
