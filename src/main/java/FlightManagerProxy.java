import exceptions.BadParamException;

public class FlightManagerProxy implements FlightManagerSubject{
    private static FlightManager manager;

    @Override
    public void createFlight(String type, Airline liner, Airport origin, Airport dest) {
        System.out.println("A flight is being created");
        if(manager == null) {
            try {
                manager = FlightManager.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        manager.createFlight(type,  liner,  origin,  dest);
    }

    @Override
    public Flight createFlight(String type, Airline liner, Airport origin, Airport dest, int size) {
        System.out.println("A flight is being created");
       if(manager == null) {
           try {
               manager = FlightManager.getInstance();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       manager.createFlight(type,  liner,  origin,  dest,  size);

        return null;
    }

    @Override
    public Flight getFlightByNumber(String flightnum) throws BadParamException {
        System.out.println("Flight number:" + flightnum + "is being retrieved");
        if(manager == null) {
            try {
                manager = FlightManager.getInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return manager.getFlightByNumber(flightnum);


    }
}
