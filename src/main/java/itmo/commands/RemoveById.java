package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий Remove_by_id
 */
public class RemoveById implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final int id;

    /**
     * @param myHashSet коллекция
     * @param id        айди
     */
    public RemoveById(MyHashSet<Organization> myHashSet, int id) {
        this.myHashSet = myHashSet;
        this.id = id;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        myHashSet.removeIf(organization -> organization.getId() == id);
    }
}
