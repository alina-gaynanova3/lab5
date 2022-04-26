package itmo.commands;

import itmo.collection.MyHashSet;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий команду информация
 */
public class Info implements UserCommand {

    private final MyHashSet<?> myHashSet;

    /**
     * @param myHashSet коллекция
     */
    public Info(MyHashSet<?> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        System.out.println("Тип: " + myHashSet.getClass().getSuperclass().getSimpleName());
        System.out.println("Дата инициализации: " + myHashSet.getCreationDate());
        System.out.println("Количество элементов: " + myHashSet.size());
    }
}