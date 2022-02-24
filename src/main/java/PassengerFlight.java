import exceptions.BadParamException;
import exceptions.NullParamException;
import jdk.jfr.Unsigned;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class PassengerFlight implements Flight{

    private int capacity; //enforce unsigned
    private Airline airline;
    private Airport origin;
    private Airport destination;
    private final String flightNumber = UUID.randomUUID().toString();
    private Date departure;

    public PassengerFlight(Airline liner, Airport start, Airport end, int size)throws NullParamException, BadParamException {
        setAirline(liner);
        setOriginAirport(start);
        setDestAirport(end);
        setDate();
        setCapacity(size);
    }

    private void setCapacity(int size) throws BadParamException, NullParamException
    {
        if(size <=0 ){
            throw new BadParamException("Zero or negative number passed to setCapacity");
        }
        capacity = size;
    }

    private void setDate() {
        departure = new Date();
    }

    private void setDestAirport(Airport pDest) throws NullParamException {
        if(pDest == null){
            throw new NullParamException("Null value passed to setAirline");
        }
        destination = pDest;
    }

    private void setOriginAirport(Airport pOrigin) throws NullParamException {
        if(pOrigin == null){
            throw new NullParamException("Null value passed to setOriginAirport");
        }
        origin = pOrigin;
    }

    private void setAirline(Airline pLiner) throws NullParamException {
        if(pLiner == null){
            throw new NullParamException("Null value passed to setAirline");
        }
        airline = pLiner;
    }

    public String getAirline() {return airline.toString();}
    public String getOriginAirport() {return origin.toString();}
    public String getDestination() {return destination.toString();}
    @Override
    public String getFlightNumber() {return flightNumber.toString();}
    public String getDeparture() {return departure.toString();}
    public String getCapacity(){return Integer.toString(capacity);}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\t\t%s", "Airline: ", getAirline() + "\n"));
        sb.append(String.format("%s\t%s", "PassengerFlight Number: ", getFlightNumber()+ "\n"));
        sb.append(String.format("%s\t\t%s", "Origin: ", getOriginAirport()+ "\n"));
        sb.append(String.format("%s\t\t\t%s", "End: ", getDestination()+ "\n"));
        sb.append(String.format("%s\t\t%s", "Departure: ", getDeparture()+ "\n"));
        sb.append(String.format("%s\t\t%s", "Capacity: ", getCapacity()+ "\n"));
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())) {
            return false;
        }
        final PassengerFlight other = (PassengerFlight) obj;
        if (!getFlightNumber().equals(other.getFlightNumber())) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(airline, origin, destination, flightNumber, departure);
    }
}
