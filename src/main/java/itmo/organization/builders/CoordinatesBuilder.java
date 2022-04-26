package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Coordinates;
import itmo.utils.WrongInputException;

/**
 * класс, описывающий CoordinatesBuilder
 */
public class CoordinatesBuilder {
    private final Coordinates coordinates;

    /**
     * CoordinatesBuilder
     */
    public CoordinatesBuilder() {
        coordinates = new Coordinates();
    }

    /**
     * @param scannable сканируемый
     * @return return
     * @throws WrongInputException эксепшн
     */
    public Coordinates build(Scannable scannable) throws WrongInputException {
        buildX(scannable);
        buildY(scannable);
        return coordinates;
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildX(Scannable scannable) throws WrongInputException {
        String x = scannable.readLine();
        coordinates.setX(Double.parseDouble(x));
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildY(Scannable scannable) throws WrongInputException {
        String y = scannable.readLine();
        coordinates.setY(Float.parseFloat(y));
    }
}
