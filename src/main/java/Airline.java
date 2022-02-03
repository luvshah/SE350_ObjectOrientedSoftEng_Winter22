import exceptions.BadParamException;
import exceptions.NullParamException;

import java.util.Objects;

public class Airline {
    private String name;
    public Airline(String sym) throws NullParamException,BadParamException {
        setName(sym);
    }

    private void setName(String sym) throws NullParamException, BadParamException {
        if(sym == null) {throw new NullParamException("Null value passed in setName");}
        if(sym .length()<=0 || sym.length() > 8 || sym.isBlank()) {throw new NullParamException("Bad value passed in setName: " + sym);}
        name = sym;
    }
    public String getName() {return name;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s", getName()));
        return sb.toString();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || (getClass() != obj.getClass())) {
            return false;
        }
        final Airline other = (Airline) obj;
        if (!getName().equals(other.getName())) {
            return false;
        }
        return true;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}
