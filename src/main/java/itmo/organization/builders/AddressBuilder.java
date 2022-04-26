package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Location;
import itmo.utils.WrongInputException;

/**
 * класс, описывающий builder адресов
 */
public class AddressBuilder {
    private final Address address;

    /**
     * AddressBuilder
     */
    public AddressBuilder() {
        address = new Address();
    }

    /**
     * @param scannable сканируемый
     * @return return
     * @throws WrongInputException эксепшн
     */
    public Address build(Scannable scannable) throws WrongInputException {
        this.buildStreet(scannable);
        this.buildZipCode(scannable);
        this.buildTown(scannable);
        return address;
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildStreet(Scannable scannable) throws WrongInputException {
        String street = scannable.readLine();
        address.setStreet(street);
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException эксепшн
     */
    private void buildZipCode(Scannable scannable) throws WrongInputException {
        String zipCode = scannable.readLine();
        address.setZipCode(zipCode);
    }


    /**
     * @param scannable сканируемый
     */
    private void buildTown(Scannable scannable) {
        Location location = null;
        try {
            location = new LocationBuilder().build(scannable);
        } catch (Exception ignored) {
        }
        address.setTown(location);
    }
}
