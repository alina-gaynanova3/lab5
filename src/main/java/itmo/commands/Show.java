package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий шоу
 */
public class Show implements UserCommand {

    private final MyHashSet<?> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public Show(MyHashSet<?> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        if (myHashSet.isEmpty()) {
            System.out.println("HashSet пуст!");
            return;
        }
        System.out.println("HashSet: ");
        myHashSet.forEach(System.out::println);
    }
}
