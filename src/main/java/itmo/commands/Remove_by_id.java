package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

public class Remove_by_id implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final int id;

    public Remove_by_id(MyHashSet<Organization> myHashSet, int id){
        this.myHashSet = myHashSet;
        this.id = id;
    }
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this).toString());
        myHashSet.removeIf(organization -> organization.getId() == id);
    }
}
