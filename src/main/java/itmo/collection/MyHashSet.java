package itmo.collection;

import java.time.LocalDateTime;
import java.util.HashSet;

/**
 * класс сделали, чтобы добавить функционал (creationDate)
 * @param <E> тип, который хранится в коллекции
 */
public class MyHashSet<E> extends HashSet<E> {
    private LocalDateTime creationDate;

    /**
     * MyHashSet
     */
    public MyHashSet() {
        super();
        creationDate = LocalDateTime.now();
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
}