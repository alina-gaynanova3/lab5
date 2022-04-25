package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

/**
 * класс для добавления
 */
public class Add implements UserCommand {

    private final MyHashSet<Organization> myHashSet;
    private final Organization organization;

    /**
     * @param myHashSet коллекция
     * @param organization организация
     */
    public Add(MyHashSet<Organization> myHashSet, Organization organization) {
        this.myHashSet = myHashSet;
        this.organization = organization;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this).toString());
        myHashSet.add(organization);
    }
}
