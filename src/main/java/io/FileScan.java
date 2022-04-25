package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScan implements Scannable{

    private final Scanner scanner;
    private int lines;

    public FileScan(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
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
