package itmo.commands;

import itmo.utils.WrongInputException;

public interface UserCommand {
    void execute() throws WrongInputException;
}
