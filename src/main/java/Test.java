import itmo.collection.JsonHelper;
import itmo.collection.MyHashSet;
import itmo.commands.*;
import itmo.organization.*;
import itmo.utils.WrongInputException;

import java.io.IOException;
import java.time.ZonedDateTime;

public class Test {
    public static void main(String[] args) throws Exception {
        Organization organization = new Organization();
        organization.setId(1);
        organization.setName("ORG");
        organization.setAnnualTurnover(3);
        organization.setCoordinates(new Coordinates(3d,4));
        organization.setFullName("ORGORG");
        organization.setCreationDate(ZonedDateTime.now());
        organization.setType(OrganizationType.PUBLIC);
        organization.setPostalAddress(new Address("street", "zipcode", new Location(2, 3.0, 6)));

        Organization organization1 = new Organization();
        organization1.setId(1);
        organization1.setName("ORG1");
        organization1.setAnnualTurnover(3);
        organization1.setCoordinates(new Coordinates(33d,4));
        organization1.setFullName("ORG1ORG1");
        organization1.setCreationDate(ZonedDateTime.now());
        organization1.setType(OrganizationType.PUBLIC);
        organization1.setPostalAddress(new Address("stree1t", "zipcode1", new Location(200, 7.0, 6)));

        MyHashSet<Organization> myHashSet = new MyHashSet<>();
        myHashSet.add(organization);
        myHashSet.add(organization1);

        JsonHelper jsonHelper = new JsonHelper(myHashSet);
        jsonHelper.toJson("test.json");

        MyHashSet<Organization> newHashSet = JsonHelper.toHashSet("test.json");
        System.out.println(newHashSet.getCreationDate());
        new Info(myHashSet).execute();
    }
}
