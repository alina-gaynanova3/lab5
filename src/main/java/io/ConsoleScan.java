package io;

import java.util.Scanner;

public class ConsoleScan implements Scannable {

    private final Scanner scanner;
    private int lines;

    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }

    @Override
    public String readLine() {
        if (!this.hasNextLine())
            System.exit(1);
        ++lines;
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    public int lines() {
        return lines;
    }

    @Override
    public void close() {
        scanner.close();
    }
}
