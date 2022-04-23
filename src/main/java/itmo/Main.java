package itmo;

import itmo.collection.MyHashSet;
import itmo.commands.Min_by_name;
import itmo.organization.Organization;

public class Main {
    public static void main(String[] args) {
        MyHashSet<Organization> myHashSet = new MyHashSet<>();

        Min_by_name min = new Min_by_name(myHashSet);
    }
}
