package itmo.commands;

import itmo.Main;
import itmo.collection.JsonHelper;
import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий сохранение
 */
public class Save implements UserCommand {
    private final MyHashSet<Organization> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public Save(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * @throws Exception выполнение
     */
    @Override
    public void execute() throws Exception {
        System.out.println(new FormatCommandOutput(50, this));
        JsonHelper jsonHelper = new JsonHelper(myHashSet);
        jsonHelper.toJson(Main.FILENAME);
    }
}
