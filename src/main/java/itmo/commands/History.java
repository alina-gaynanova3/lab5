package itmo.commands;

import itmo.utils.CommandHistory;
import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий историю
 */
public class History implements UserCommand {
    /**
     * выполнение
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        CommandHistory.getHistory().forEach(command -> System.out.println(command.getClass().getSimpleName()));
    }
}
