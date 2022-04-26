package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * класс, описывающий FileScan
 */
public class FileScan implements Scannable {

    private final Scanner scanner;
    private int lines;

    /**
     * @param filename имя файла
     * @throws FileNotFoundException Exception
     */
    public FileScan(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
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
     * закрыть
     */
    @Override
    public void close() {
        scanner.close();
    }
}
