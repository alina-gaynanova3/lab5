package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.WrongInputException;

public class Update_id implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final Organization organization;
    private final int id;

    public Update_id(MyHashSet<Organization> myHashSet, Organization organization, int id){
        this.myHashSet = myHashSet;
        this.organization = organization;
        this.id = id;
    }

    @Override
    public void execute() throws WrongInputException {
        if (myHashSet.removeIf(organization1 -> organization1.getId() == id)){
            organization.setId(id);
            myHashSet.add(organization);
        }
    }
}
