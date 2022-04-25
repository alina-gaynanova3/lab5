package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Location;
import itmo.utils.WrongInputException;

public class AddressBuilder {
    private Address address;

    public AddressBuilder() {
        address = new Address();
    }

    public Address build(Scannable scannable) throws WrongInputException {
        this.buildStreet(scannable);
        this.buildZipCode(scannable);
        this.buildTown(scannable);
        return address;
    }

    private void buildStreet(Scannable scannable) throws WrongInputException {
        String street = scannable.readLine();
        address.setStreet(street);
    }

    private void buildZipCode(Scannable scannable) throws WrongInputException {
        String zipCode = scannable.readLine();
        address.setZipCode(zipCode);
    }


    private void buildTown(Scannable scannable){
        Location location = null;
        try {
            location = new LocationBuilder().build(scannable);
        } catch (Exception ignored){}
        address.setTown(location);
    }
}
