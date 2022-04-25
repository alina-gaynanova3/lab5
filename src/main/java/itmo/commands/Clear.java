package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.utils.FormatCommandOutput;

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
        System.out.println(new FormatCommandOutput(50, this));
        myHashSet.clear();
        System.out.println("Коллекция очищена!");
    }
}
