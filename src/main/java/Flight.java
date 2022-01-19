import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
import exceptions.NullParamException;
public class Flight {
    private Airline airline;
    private Airport origin;
    private Airport destination;
    private final String flightNumber = UUID.randomUUID().toString();
    private Date departure;

    public Flight(Airline liner, Airport start, Airport end) throws NullParamException {
        setAirline(liner);
        setOriginAirport(start);
        setDestAirport(end);
        setDate();
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

    public Airline getAirline() {return airline;}
    public Airport getOriginAirport() {return origin;}
    public Airport getDestination() {return destination;}
    public String getFlightNumber() {return flightNumber;}
    public Date getDeparture() {return departure;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s\t\t%s", "Airline: ", getAirline().getName() + "\n"));
        sb.append(String.format("%s\t%s", "Flight Number: ", getFlightNumber().toString()+ "\n"));
        sb.append(String.format("%s\t\t%s", "Origin: ", getOriginAirport().getSymbol()+ "\n"));
        sb.append(String.format("%s\t\t\t%s", "End: ", getDestination().getSymbol()+ "\n"));
        sb.append(String.format("%s\t\t%s", "Departure: ", getDeparture().toString()+ "\n"));
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())) {
            return false;
        }
        final Flight other = (Flight) obj;
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
