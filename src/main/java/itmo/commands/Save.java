package itmo.commands;

import itmo.Main;
import itmo.collection.JsonHelper;
import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.FormatCommandOutput;

import java.io.IOException;

public class Save implements UserCommand {
    private final MyHashSet<Organization> myHashSet;

    public Save(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() throws Exception {
        System.out.println(new FormatCommandOutput(50, this).toString());
        JsonHelper jsonHelper = new JsonHelper(myHashSet);
        jsonHelper.toJson(Main.FILENAME);
    }
}
