package io;

import java.util.Scanner;

/**
 * класс, описывающий ConsoleScan
 */
public class ConsoleScan implements Scannable {

    private final Scanner scanner;
    private int lines;

    /**
     * ConsoleScan
     */
    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }

    /**
     * @return return
     */
    @Override
    public String readLine() {
        if (!this.hasNextLine())
            System.exit(1);
        ++lines;
        return scanner.nextLine();
    }

    /**
     * @return return
     */
    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    /**
     * @return return
     */
    @Override
    public int lines() {
        return lines;
    }

    /**
     * return
     */
    @Override
    public void close() {
        scanner.close();
    }
}
