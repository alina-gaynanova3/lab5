package itmo.utils;

import itmo.commands.UserCommand;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private static final List<UserCommand> history = new ArrayList<>();

    public static void add(UserCommand command) {
        if (history.size() == 10) {
            history.remove(0);
        }

        history.add(command);
    }

    public static List<UserCommand> getHistory() {
        return history;
    }
}
