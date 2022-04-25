package itmo.commands;

import itmo.collection.MyHashSet;

/**
 * класс для очистки
 */
public class Clear implements UserCommand {

    private final MyHashSet<?> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public Clear(MyHashSet<?> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * выполнение очистки
     */
    @Override
    public void execute() {
        myHashSet.clear();
        System.out.println("Коллекция очищена!");
    }
}
