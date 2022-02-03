import exceptions.BadParamException;
import exceptions.NullParamException;

import java.util.Objects;

public class Airport {

    private String sym;

    public Airport(String symbol) throws BadParamException, NullParamException {
        setSymbol(symbol);
    }
    private void setSymbol(String symbol) throws BadParamException, NullParamException
    {
        if(symbol == null) throw new NullParamException("Null parameter in setSymbol(String)");
        if(symbol.isEmpty() || symbol.length() < 3) throw new BadParamException("Bad parameter in setSymbol(String)");
        sym = symbol.toUpperCase().substring(0,3);
    }
    public String getSymbol() {return sym;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s", getSymbol()));
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())) {
            return false;
        }
        final Airport other = (Airport) obj;
        if (!getSymbol().equals(other.getSymbol())) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(sym);
    }
}

