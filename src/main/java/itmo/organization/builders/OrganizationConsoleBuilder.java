package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Coordinates;
import itmo.organization.Organization;
import itmo.organization.OrganizationType;
import itmo.utils.WrongInputException;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class OrganizationConsoleBuilder {
    private final Organization organization;

    public OrganizationConsoleBuilder() {
        organization = new Organization();
    }

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

    private void buildId() throws WrongInputException {
        int id = -1;
        Random random = new Random();
        while (id <= 0)
            id = random.nextInt();
        organization.setId(id);
    }

    private void buildCreationDate() throws WrongInputException {
        organization.setCreationDate(ZonedDateTime.now());
    }

    private void buildName(Scannable scannable) {
        System.out.println("Введите имя: ");
        String name = scannable.readLine();
        try {
            organization.setName(name);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildName(scannable);
        }
    }

    private void buildFullName(Scannable scannable) {
        System.out.println("Введите Full имя: ");
        String fullname = scannable.readLine();
        try {
            organization.setFullName(fullname);
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildFullName(scannable);
        }
    }

    private void buildCoordinates(Scannable scannable) throws WrongInputException {
        Coordinates coordinates = new CoordinatesConsoleBuilder().build(scannable);
        organization.setCoordinates(coordinates);
    }

    private void buildAnnualTurnover(Scannable scannable) {
        System.out.println("Введите annual turnover: ");
        String annualTurnover = scannable.readLine();
        try {
            organization.setAnnualTurnover(Integer.parseInt(annualTurnover));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildAnnualTurnover(scannable);
        }
    }

    private void buildOrganizationType(Scannable scannable) {
        System.out.println("Введите OrganizationType: " + Arrays.toString(OrganizationType.values()));
        String organizationType = scannable.readLine();
        if (organizationType.equals("")) {
            organization.setType(null);
            return;
        }
        try {
            organization.setType(OrganizationType.valueOf(organizationType.trim().toUpperCase(Locale.ROOT)));
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildOrganizationType(scannable);
        }
    }

    private void buildPostalAddress(Scannable scannable) throws WrongInputException {
        Address address = new AddressConsoleBuilder().build(scannable);
        organization.setPostalAddress(address);
    }
}
