package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;

public class Remove_lower implements UserCommand {

    private final MyHashSet<Organization> myHashSet;
    private final Organization organization;

    public Remove_lower(MyHashSet<Organization> myHashSet, Organization organization){
        this.myHashSet = myHashSet;
        this.organization = organization;
    }

    @Override
    public void execute() {
        myHashSet.removeIf(organization1 -> new OrganizationNameComparator().compare(organization1, organization) < 0);
    }
}
