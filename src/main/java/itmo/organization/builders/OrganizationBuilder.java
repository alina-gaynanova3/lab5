package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Coordinates;
import itmo.organization.Organization;
import itmo.organization.OrganizationType;
import itmo.utils.WrongInputException;

import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.Random;

/**
 * класс, описывающий OrganizationBuilder
 */
public class OrganizationBuilder {
    private final Organization organization;

    /**
     * OrganizationBuilder
     */
    public OrganizationBuilder() {
        organization = new Organization();
    }

    /**
     * @param scannable сканируемый
     * @return return
     * @throws WrongInputException Exception
     */
    public Organization build(Scannable scannable) throws WrongInputException {
        this.buildId();
        this.buildCreationDate();
        this.buildName(scannable);
        this.buildFullName(scannable);
        this.buildCoordinates(scannable);
        this.buildAnnualTurnover(scannable);
        this.buildOrganizationType(scannable);
        this.buildPostalAddress(scannable);
        return organization;
    }

    /**
     * @throws WrongInputException Exception
     */
    private void buildId() throws WrongInputException {
        int id = -1;
        Random random = new Random();
        while (id <= 0)
            id = random.nextInt();
        organization.setId(id);
    }

    /**
     * @throws WrongInputException Exception
     */
    private void buildCreationDate() throws WrongInputException {
        organization.setCreationDate(ZonedDateTime.now());
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildName(Scannable scannable) throws WrongInputException {
        String name = scannable.readLine();
        organization.setName(name);
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildFullName(Scannable scannable) throws WrongInputException {
        String fullname = scannable.readLine();
        organization.setFullName(fullname);
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildCoordinates(Scannable scannable) throws WrongInputException {
        Coordinates coordinates = new CoordinatesBuilder().build(scannable);
        organization.setCoordinates(coordinates);
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildAnnualTurnover(Scannable scannable) throws WrongInputException {
        String annualTurnover = scannable.readLine();
        organization.setAnnualTurnover(Integer.parseInt(annualTurnover));
    }

    /**
     * @param scannable сканируемый
     */
    private void buildOrganizationType(Scannable scannable) {
        String organizationType = scannable.readLine();
        if (organizationType.equals("")) {
            organization.setType(null);
            return;
        }
        organization.setType(OrganizationType.valueOf(organizationType.trim().toUpperCase(Locale.ROOT)));
    }

    /**
     * @param scannable сканируемый
     * @throws WrongInputException Exception
     */
    private void buildPostalAddress(Scannable scannable) throws WrongInputException {
        Address address = new AddressConsoleBuilder().build(scannable);
        organization.setPostalAddress(address);
    }
}
