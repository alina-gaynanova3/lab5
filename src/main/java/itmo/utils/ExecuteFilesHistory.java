package itmo.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExecuteFilesHistory {
    private final List<File> history;

    public ExecuteFilesHistory() {
        history = new ArrayList<>();
    }

    public void add(File file) {
        history.add(file);
    }

    public boolean contains(File file) {
        return history.stream().anyMatch(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }

    public void remove(File file) {
        history.removeIf(file1 -> file1.getAbsolutePath().equals(file.getAbsolutePath()));
    }
}
