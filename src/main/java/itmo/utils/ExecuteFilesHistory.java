package itmo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * класс, описывающий ExecuteFilesHistory
 */
public class ExecuteFilesHistory {
    private final List<File> history;

    /**
     * ExecuteFilesHistory
     */
    public ExecuteFilesHistory() {
        history = new ArrayList<>();
    }

    /**
     * @param file файл
     */
    public void add(File file) {
        history.add(file);
    }

    /**
     * @param file файл
     * @return return
     */
    public boolean contains(File file) {
        return history.stream().anyMatch(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }

    /**
     * @param file файл
     */
    public void remove(File file) {
        history.removeIf(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }
}
