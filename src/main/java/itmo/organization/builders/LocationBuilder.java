package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Location;
import itmo.utils.WrongInputException;

public class LocationBuilder {
    private Location location;

    public LocationBuilder() {
        location = new Location();
    }

    public Location build(Scannable scannable) throws WrongInputException {
        this.buildX(scannable);
        this.buildY(scannable);
        this.buildZ(scannable);
        return location;
    }


    private void buildX(Scannable scannable) throws WrongInputException {
        String x = scannable.readLine();
        if (x.equals(""))
            throw new WrongInputException("field is null");

        location.setX(Double.parseDouble(x));
    }

    private void buildY(Scannable scannable) throws WrongInputException {
        String y = scannable.readLine();
        location.setY(Double.valueOf(y));
    }

    private void buildZ(Scannable scannable) throws WrongInputException {
        String z = scannable.readLine();
        location.setZ(Integer.valueOf(z));
    }
}
