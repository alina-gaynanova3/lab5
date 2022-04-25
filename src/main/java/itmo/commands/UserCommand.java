package itmo.commands;

import itmo.utils.WrongInputException;

import java.io.IOException;

public interface UserCommand {
    void execute() throws Exception;
}
