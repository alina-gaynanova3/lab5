package itmo.commands;

import io.FileScan;
import io.Scannable;
import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.ExecuteFilesHistory;
import itmo.utils.FormatCommandOutput;
import itmo.utils.WrongInputException;

import java.io.File;

/**
 * класс, описывающий Execute_script
 */
public class Execute_script implements UserCommand {
    private final MyHashSet<Organization> myHashSet;
    private final ExecuteFilesHistory executeFilesHistory;
    private final String filename;

    /**
     * @param myHashSet           коллекция
     * @param executeFilesHistory выполнение истории
     * @param filename            имя файла
     */
    public Execute_script(MyHashSet<Organization> myHashSet, ExecuteFilesHistory executeFilesHistory, String filename) {
        this.myHashSet = myHashSet;
        this.executeFilesHistory = executeFilesHistory;
        this.filename = filename;
    }

    /**
     * @throws Exception Exception
     */
    @Override
    public void execute() throws Exception {
        System.out.println(new FormatCommandOutput(50, this));
        File file = new File(filename);
        if (!file.canRead())
            throw new WrongInputException("не возможно прочитать файл");

        if (executeFilesHistory.contains(file))
            throw new WrongInputException("рекурсия_))))))))))");
        executeFilesHistory.add(file);
        CommandReader commandReader = new CommandReader(myHashSet, executeFilesHistory);
        Scannable scannable = new FileScan(filename);
        try {
            while (scannable.hasNextLine()) {
                commandReader.getCommand(scannable, false).execute();
            }
        } catch (Exception e) {
            System.out.println("Ошибка в файле " + filename + " на строчке: " + scannable.lines() + ": " + e.getMessage());
        }
        executeFilesHistory.remove(file);
    }
}
