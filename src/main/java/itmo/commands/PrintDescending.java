package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

public class PrintDescending implements UserCommand{
    private final MyHashSet<Organization> myHashSet;

    public PrintDescending(MyHashSet<Organization> myHashSet){
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this).toString());
        myHashSet.stream().sorted(new OrganizationNameComparator()).forEach(System.out::println);
    }
}
