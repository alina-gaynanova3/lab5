package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileScan implements Scannable{

    private final Scanner scanner;

    public FileScan(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
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
