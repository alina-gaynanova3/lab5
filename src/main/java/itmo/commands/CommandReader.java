package itmo.commands;

import io.Scannable;
import itmo.collection.MyHashSet;
import itmo.organization.Address;
import itmo.organization.Organization;
import itmo.organization.builders.AddressBuilder;
import itmo.organization.builders.AddressConsoleBuilder;
import itmo.organization.builders.OrganizationBuilder;
import itmo.organization.builders.OrganizationConsoleBuilder;
import itmo.utils.ExecuteFilesHistory;
import itmo.utils.WrongInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * класс для считывания команд
 */
public class CommandReader {
    /**
     * Collection
     */
    private MyHashSet<Organization> myHashSet;
    private ExecuteFilesHistory executeFilesHistory;

    /**
     * @param myHashSet коллекция
     * @param executeFilesHistory история файлов
     */
    public CommandReader(MyHashSet<Organization> myHashSet, ExecuteFilesHistory executeFilesHistory) {
        this.myHashSet = myHashSet;
        this.executeFilesHistory = executeFilesHistory;
    }

    /**
     * @param inputString инпут стринг
     * @return list of words
     */
    private List<String> split(String inputString){
        List<String> list = new ArrayList<>(Arrays.asList(inputString.split(" ")));
        list.removeIf(s -> s.equals(""));
        return list;
    }

    /**
     * @param scannable скам
     * @return command
     * @throws WrongInputException
     */
    public UserCommand getCommand(Scannable scannable, boolean isFromConsole) throws WrongInputException {
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
            case "save":
                return new Save(myHashSet);
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
            case "execute_script":{
                if (words.size() < 2)
                    throw new WrongInputException("Нет параметра");

                return new Execute_script(myHashSet, executeFilesHistory, words.get(1));
            }
            case "add": {
                Organization organization;
                if (isFromConsole)
                    organization = new OrganizationConsoleBuilder().build(scannable);
                else
                    organization = new OrganizationBuilder().build(scannable);
                return new Add(myHashSet, organization);
            }
            case "add_if_max": {
                Organization organization;
                if (isFromConsole)
                    organization = new OrganizationConsoleBuilder().build(scannable);
                else
                    organization = new OrganizationBuilder().build(scannable);
                return new Add_if_max(myHashSet, organization);
            }
            case "remove_lower": {
                Organization organization;
                if (isFromConsole)
                    organization = new OrganizationConsoleBuilder().build(scannable);
                else
                    organization = new OrganizationBuilder().build(scannable);
                return new Remove_lower(myHashSet, organization);
            }
            case "update": {
                if (words.size() < 2)
                    throw new WrongInputException("Нет параметра");
                Organization organization;
                if (isFromConsole)
                    organization = new OrganizationConsoleBuilder().build(scannable);
                else
                    organization = new OrganizationBuilder().build(scannable);
                return new Update_id(myHashSet, organization, Integer.parseInt(words.get(1)));
            }
            case "remove_all_by_postal_address": {
                Address address;
                if (isFromConsole)
                    address = new AddressConsoleBuilder().build(scannable);
                else
                    address = new AddressBuilder().build(scannable);
                return new Remove_all_by_postal_address(myHashSet, address);
            }

            default:
                throw new WrongInputException("Нет такой команды: " + command);
        }
    }
}
