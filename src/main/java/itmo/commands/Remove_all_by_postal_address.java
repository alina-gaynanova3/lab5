package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Address;
import itmo.organization.Organization;

public class Remove_all_by_postal_address implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final Address address;

    public Remove_all_by_postal_address(MyHashSet<Organization> myHashSet, Address address) {
        this.myHashSet = myHashSet;
        this.address = address;
    }

    @Override
    public void execute() {
        myHashSet.removeIf(organization -> organization.getPostalAddress().equals(address));
    }
}
