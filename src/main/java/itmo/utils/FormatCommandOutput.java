package itmo.utils;

import itmo.commands.UserCommand;

/**
 * класс, описывающий FormatCommandOutput
 */
public class FormatCommandOutput {

    private final int allChars;
    private final UserCommand command;

    /**
     * @param allChars allChars
     * @param command  комдна
     */
    public FormatCommandOutput(int allChars, UserCommand command) {
        this.allChars = allChars;
        this.command = command;
    }

    /**
     * @return return
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < (allChars - command.getClass().getSimpleName().length()) / 2; ++i) {
            stringBuilder.append("=");
        }
        String preHeader = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < (allChars - command.getClass().getSimpleName().length()) / 2 + (allChars - command.getClass().getSimpleName().length()) % 2; ++i) {
            stringBuilder.append("=");
        }
        String postHeader = stringBuilder.toString();

        return preHeader + command.getClass().getSimpleName() + postHeader;
    }
}
