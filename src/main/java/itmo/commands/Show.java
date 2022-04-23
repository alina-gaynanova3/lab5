package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.utils.FormatCommandOutput;

public class Show implements UserCommand {

    private MyHashSet<?> myHashSet;

    public Show(MyHashSet<?> myHashSet) {
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        if (myHashSet.isEmpty()){
            System.out.println("HashSet пуст!");
            return;
        }
        System.out.println("HashSet: ");
        myHashSet.forEach(System.out::println);
    }
}
