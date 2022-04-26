package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Coordinates;

/**
 * класс, описывающий CoordinatesConsoleBuilder
 */
public class CoordinatesConsoleBuilder {
    private final Coordinates coordinates;

    /**
     * CoordinatesConsoleBuilder
     */
    public CoordinatesConsoleBuilder() {
        coordinates = new Coordinates();
    }

    /**
     * @param scannable сканируемый
     * @return return
     */
    public Coordinates build(Scannable scannable) {
        buildX(scannable);
        buildY(scannable);
        return coordinates;
    }

    /**
     * @param scannable сканируемый
     */
    private void buildX(Scannable scannable) {
        System.out.println("Введите координату х (double): ");
        String x = scannable.readLine();
        try {
            coordinates.setX(Double.parseDouble(x));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildX(scannable);
        }
    }

    /**
     * @param scannable сканируемый
     */
    private void buildY(Scannable scannable) {
        System.out.println("Введите координату y (float): ");
        String y = scannable.readLine();
        try {
            coordinates.setY(Float.parseFloat(y));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildY(scannable);
        }
    }
}
