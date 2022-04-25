package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Coordinates;
import itmo.utils.WrongInputException;

public class CoordinatesBuilder {
    private final Coordinates coordinates;

    public CoordinatesBuilder() {
        coordinates = new Coordinates();
    }

    public Coordinates build(Scannable scannable) throws WrongInputException {
        buildX(scannable);
        buildY(scannable);
        return coordinates;
    }

    private void buildX(Scannable scannable) throws WrongInputException {
        String x = scannable.readLine();
        coordinates.setX(Double.parseDouble(x));
    }

    private void buildY(Scannable scannable) throws WrongInputException {
        String y = scannable.readLine();
        coordinates.setY(Float.parseFloat(y));
    }
}
