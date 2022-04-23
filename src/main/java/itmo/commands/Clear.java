package itmo.commands;

import itmo.collection.MyHashSet;

public class Clear implements UserCommand {

    private final MyHashSet<?> myHashSet;

    public Clear(MyHashSet<?> myHashSet) {
        this.myHashSet = myHashSet;
    }

    @Override
    public void execute() {
        myHashSet.clear();
        System.out.println("Коллекция очищена!");
    }
}
