package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Coordinates;
import itmo.utils.WrongInputException;

public class CoordinatesConsoleBuilder {
    private Coordinates coordinates;

    public CoordinatesConsoleBuilder(){
        coordinates = new Coordinates();
    }

    public Coordinates build(Scannable scannable){
        buildX(scannable);
        buildY(scannable);
        return coordinates;
    }

    private void buildX(Scannable scannable){
        System.out.println("Введите координату х: ");
        String x = scannable.readLine();
        try {
            coordinates.setX(Double.parseDouble(x));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildX(scannable);
        }
    }

    private void buildY(Scannable scannable){
        System.out.println("Введите координату y: ");
        String y = scannable.readLine();
        try {
            coordinates.setY(Float.parseFloat(y));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildY(scannable);
        }
    }
}
