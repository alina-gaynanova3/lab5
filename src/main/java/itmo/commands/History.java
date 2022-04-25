package itmo.commands;

import itmo.utils.CommandHistory;

public class History implements UserCommand {
    /**
     * выполнение
     */
    @Override
    public void execute() {
        CommandHistory.getHistory().forEach(command -> System.out.println(command.getClass().getSimpleName()));
    }
}
