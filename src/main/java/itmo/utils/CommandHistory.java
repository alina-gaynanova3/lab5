package itmo.utils;

import itmo.commands.UserCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * класс, описывающий CommandHistory
 */
public class CommandHistory {
    private static final List<UserCommand> history = new ArrayList<>();

    /**
     * @param command команда
     */
    public static void add(UserCommand command) {
        if (history.size() == 10) {
            history.remove(0);
        }

        history.add(command);
    }

    /**
     * @return return
     */
    public static List<UserCommand> getHistory() {
        return history;
    }
}
