package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Location;
import itmo.utils.WrongInputException;

/**
 * класс, описывающий LocationConsoleBuilder
 */
public class LocationConsoleBuilder {
    private final Location location;

    /**
     * LocationConsoleBuilder
     */
    public LocationConsoleBuilder() {
        location = new Location();
    }

    /**
     * @param scannable scannable
     * @return return
     * @throws WrongInputException Exception
     */
    public Location build(Scannable scannable) throws WrongInputException {
        this.buildX(scannable);
        this.buildY(scannable);
        this.buildZ(scannable);
        return location;
    }


    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildX(Scannable scannable) throws WrongInputException {
        System.out.println("Введите координату х: ");
        String x = scannable.readLine();
        if (x.equals(""))
            throw new WrongInputException("field is null");
        try {
            location.setX(Double.parseDouble(x));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildX(scannable);
        }
    }

    /**
     * @param scannable сканируемый
     */
    private void buildY(Scannable scannable) {
        System.out.println("Введите координату y: ");
        String y = scannable.readLine();
        try {
            location.setY(Double.valueOf(y));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildY(scannable);
        }
    }

    /**
     * @param scannable сканируемый
     */
    private void buildZ(Scannable scannable) {
        System.out.println("Введите координату z: ");
        String z = scannable.readLine();
        try {
            location.setZ(Integer.valueOf(z));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildZ(scannable);
        }
    }
}
