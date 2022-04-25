package itmo.commands;

import io.Scannable;
import itmo.collection.MyHashSet;
import itmo.organization.Organization;
import itmo.utils.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * класс для считывания команд
 */
public class CommandReader {
    private MyHashSet<Organization> myHashSet;

    /**
     * @param myHashSet колеекция
     */
    public CommandReader(MyHashSet<Organization> myHashSet) {
        this.myHashSet = myHashSet;
    }

    /**
     * @param inputString инпут стринг
     * @return
     */
    private List<String> split(String inputString){
        List<String> list = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        list.removeIf(s -> s.equals(""));
        return list;
    }

    /**
     * @param scannable скан
     * @return
     * @throws WrongInputException
     */
    public UserCommand getCommand(Scannable scannable) throws WrongInputException {
        String commandLine = scannable.readLine();

        List<String> words = split(commandLine);

        if (words.isEmpty())
            throw new WrongInputException("Ничего нет");

        String command = words.get(0);

        switch (command){
            case "info":
                return new Info(myHashSet);
            case "show":
                return new Show(myHashSet);
            case "exit":
                return new Exit();
            case "help":
                return new Help();
            case "clear":
                return new Clear(myHashSet);
            case "print_descending":
                return new PrintDescending(myHashSet);
            case "min_by_name":
                return new Min_by_name(myHashSet);
            case "history":
                return new History();
            case "remove_by_id":{
                if (words.size() < 2)
                    throw new WrongInputException("Нет параметра");

                return new Remove_by_id(myHashSet, Integer.parseInt(words.get(1)));
            }

            default:
                throw new WrongInputException("Нет такой команды: " + command);
        }
    }
}
