package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий PrintDescending
 */
public class PrintDescending implements UserCommand {
    private final MyHashSet<Organization> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public PrintDescending(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        myHashSet.stream().sorted(new OrganizationNameComparator()).forEach(System.out::println);
    }
}
