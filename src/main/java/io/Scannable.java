package io;

public interface Scannable {
    String readLine();
    boolean hasNextLine();
    int lines();
    void close();
}
