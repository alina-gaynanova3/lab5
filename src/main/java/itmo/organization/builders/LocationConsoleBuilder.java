package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Location;

public class LocationConsoleBuilder {
    private Location location;

    public LocationConsoleBuilder() {
        location = new Location();
    }

    public Location build(Scannable scannable) {
        this.buildX(scannable);
        this.buildY(scannable);
        this.buildZ(scannable);
        return location;
    }


    private void buildX(Scannable scannable) {
        System.out.println("Введите координату х: ");
        String x = scannable.readLine();
        try {
            location.setX(Double.parseDouble(x));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildX(scannable);
        }
    }

    private void buildY(Scannable scannable) {
        System.out.println("Введите координату y: ");
        String y = scannable.readLine();
        try {
            location.setX(Double.parseDouble(y));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildY(scannable);
        }
    }

    private void buildZ(Scannable scannable) {
        System.out.println("Введите координату z: ");
        String z = scannable.readLine();
        try {
            location.setX(Double.parseDouble(z));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildZ(scannable);
        }
    }
}
