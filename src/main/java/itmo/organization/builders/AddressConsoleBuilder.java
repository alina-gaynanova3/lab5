package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Location;


/**
 * класс, описывающий AddressConsoleBuilder
 */
public class AddressConsoleBuilder {
    private final Address address;

    /**
     * AddressConsoleBuilder
     */
    public AddressConsoleBuilder() {
        address = new Address();
    }

    /**
     * @param scannable сканируемый
     * @return return
     */
    public Address build(Scannable scannable) {
        this.buildStreet(scannable);
        this.buildZipCode(scannable);
        this.buildTown(scannable);
        return address;
    }

    /**
     * @param scannable сканируемый
     */
    private void buildStreet(Scannable scannable) {
        System.out.println("Введите адрес: ");
        String street = scannable.readLine();
        try {
            address.setStreet(street);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildStreet(scannable);
        }
    }

    /**
     * @param scannable сканируемый
     */
    private void buildZipCode(Scannable scannable) {
        System.out.println("Введите zip Code: ");
        String zipCode = scannable.readLine();
        try {
            address.setZipCode(zipCode);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildZipCode(scannable);
        }
    }


    private void buildTown(Scannable scannable) {
        Location location = null;
        try {
            location = new LocationConsoleBuilder().build(scannable);
        } catch (Exception ignored) {
        }
        address.setTown(location);
    }
}
