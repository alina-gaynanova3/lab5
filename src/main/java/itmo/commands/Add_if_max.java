package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

import java.util.Optional;

/**
 * класс для добавления максимального
 */
public class Add_if_max implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final Organization organization;

    /**
     * @param myHashSet    коллекция
     * @param organization организауия
     */
    public Add_if_max(MyHashSet<Organization> myHashSet, Organization organization) {
        this.myHashSet = myHashSet;
        this.organization = organization;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        Optional<Organization> max = myHashSet.stream().max(new OrganizationNameComparator());
        if (!max.isPresent()) {
            myHashSet.add(organization);
            return;
        }
        if (new OrganizationNameComparator().compare(organization, max.get()) > 0) {
            myHashSet.add(organization);
        }
    }
}
