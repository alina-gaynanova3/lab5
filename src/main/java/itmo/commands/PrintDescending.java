package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;

public class PrintDescending implements UserCommand{
    private final MyHashSet<Organization> myHashSet;

    public PrintDescending(MyHashSet<Organization> myHashSet){
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() {
        myHashSet.stream().sorted(new OrganizationNameComparator()).forEach(System.out::println);
    }
}
