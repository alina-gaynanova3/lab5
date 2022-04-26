package itmo;

import io.ConsoleScan;
import io.Scannable;
import itmo.collection.JsonHelper;
import itmo.collection.MyHashSet;
import itmo.commands.CommandReader;
import itmo.commands.UserCommand;
import itmo.organization.Organization;
import itmo.utils.CommandHistory;
import itmo.utils.ExecuteFilesHistory;

public class Main {
    public static String FILENAME;

    public static void main(String[] args) {
        FILENAME = System.getenv("filename");

        MyHashSet<Organization> myHashSet = new MyHashSet<>();
        try {
            myHashSet = JsonHelper.toHashSet(FILENAME);
        } catch (Exception e) {
            System.out.println("Не удается взять коллекцию из файла");
        }

        ExecuteFilesHistory executeFilesHistory = new ExecuteFilesHistory();
        CommandReader commandReader = new CommandReader(myHashSet, executeFilesHistory);
        Scannable scannable = new ConsoleScan();
        while (true) {
            System.out.println("Введите команду:");
            try {
                UserCommand command = commandReader.getCommand(scannable, true);
                CommandHistory.getHistory().add(command);
                command.execute();
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
