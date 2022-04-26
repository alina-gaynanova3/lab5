package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.organization.comparators.OrganizationNameComparator;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий Remove_lower
 */
public class RemoveLower implements UserCommand {

    private final MyHashSet<Organization> myHashSet;
    private final Organization organization;

    /**
     * @param myHashSet    коллекция
     * @param organization организация
     */
    public RemoveLower(MyHashSet<Organization> myHashSet, Organization organization) {
        this.myHashSet = myHashSet;
        this.organization = organization;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        myHashSet.removeIf(organization1 -> new OrganizationNameComparator().compare(organization1, organization) < 0);
    }
}
