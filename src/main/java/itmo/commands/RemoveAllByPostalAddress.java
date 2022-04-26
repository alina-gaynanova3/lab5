package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Address;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий Remove_all_by_postal_address
 */
public class RemoveAllByPostalAddress implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final Address address;

    /**
     * @param myHashSet коллекция
     * @param address   адрес
     */
    public RemoveAllByPostalAddress(MyHashSet<Organization> myHashSet, Address address) {
        this.myHashSet = myHashSet;
        this.address = address;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        myHashSet.removeIf(organization -> organization.getPostalAddress().equals(address));
    }
}
