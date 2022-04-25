package itmo.commands;

import itmo.utils.CommandHistory;
import itmo.utils.FormatCommandOutput;

public class History implements UserCommand {
    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this).toString());
        CommandHistory.getHistory().forEach(command -> System.out.println(command.getClass().getSimpleName()));
    }
}
