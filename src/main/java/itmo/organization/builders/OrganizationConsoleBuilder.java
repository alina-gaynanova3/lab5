package itmo.organization.builders;

import io.Scannable;
import itmo.organization.Address;
import itmo.organization.Location;
import itmo.organization.Organization;
import itmo.organization.OrganizationType;
import itmo.utils.WrongInputException;

public class OrganizationConsoleBuilder {
    private Organization organization;

    public OrganizationConsoleBuilder(){
        organization = new Organization();
    }

    public Organization build(Scannable scannable) throws WrongInputException {
        this.buildName(scannable);
        this.buildFullName(scannable);
        this.buildAnnualTurnover(scannable);
        this.buildOrganizationType(scannable);
        this.buildPostalAddress(scannable);
        return organization;
    }

    private void buildName(Scannable scannable){
        System.out.println("Введите имя: ");
        String name = scannable.readLine();
        try{
            organization.setName(name);
        } catch (Exception e){
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildName(scannable);
        }
    }

    private void buildFullName(Scannable scannable){
        System.out.println("Введите Full имя: ");
        String fullname = scannable.readLine();
        try{
            organization.setFullName(fullname);
        } catch (Exception e){
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildFullName(scannable);
        }
    }

    private void buildAnnualTurnover(Scannable scannable){
        System.out.println("Введите annual turnover: ");
        String annualTurnover = scannable.readLine();
        try{
            organization.setAnnualTurnover(Integer.parseInt(annualTurnover));
        } catch (Exception e){
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildAnnualTurnover(scannable);
        };
    }
    private void buildOrganizationType(Scannable scannable){
        System.out.println("Введите OrganizationType: ");
        String organizationType = scannable.readLine();
        if (organizationType.equals("")){
            organization.setType(null);
            return;
        }
        try{
            organization.setType(OrganizationType.valueOf(organizationType));
        }catch (Exception e){
            System.out.println("Что-то пошло не так: " + e.getMessage());
            buildOrganizationType(scannable);
        }
    }
    private void buildPostalAddress(Scannable scannable) throws WrongInputException {
        Address address = new AddressConsoleBuilder().build(scannable);
        organization.setPostalAddress(address);
    }
}
