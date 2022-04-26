package io;

/**
 * интерфейс сканируемый
 */
public interface Scannable {
    /**
     * @return return
     */
    String readLine();

    /**
     * @return return
     */
    boolean hasNextLine();

    /**
     * @return return
     */
    int lines();

    void close();
}
