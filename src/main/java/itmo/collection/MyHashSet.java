package itmo.collection;

import java.time.LocalDateTime;
import java.util.HashSet;

public class MyHashSet<E> extends HashSet<E> {
    private LocalDateTime creationDate;

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