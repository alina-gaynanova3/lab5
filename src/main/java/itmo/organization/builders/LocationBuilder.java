package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Location;
import itmo.utils.WrongInputException;

/**
 * класс, описывающий LocationBuilder
 */
public class LocationBuilder {
    private final Location location;

    /**
     * LocationBuilder
     */
    public LocationBuilder() {
        location = new Location();
    }

    /**
     * @param scannable сканируемый
     * @return return
     * @throws WrongInputException эксепшн
     */
    public Location build(Scannable scannable) throws WrongInputException {
        this.buildX(scannable);
        this.buildY(scannable);
        this.buildZ(scannable);
        return location;
    }


    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildX(Scannable scannable) throws WrongInputException {
        String x = scannable.readLine();
        if (x.equals(""))
            throw new WrongInputException("field is null");

        location.setX(Double.parseDouble(x));
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildY(Scannable scannable) throws WrongInputException {
        String y = scannable.readLine();
        location.setY(Double.valueOf(y));
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildZ(Scannable scannable) throws WrongInputException {
        String z = scannable.readLine();
        location.setZ(Integer.valueOf(z));
    }
}
