package io;

import java.util.Scanner;

public class ConsoleScan implements Scannable {

    private final Scanner scanner;

    public ConsoleScan() {
        scanner = new Scanner(System.in);
    }


    @Override
    public String readLine() {
        if (!this.hasNextLine())
            return null;
        return scanner.nextLine();
    }

    @Override
    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
