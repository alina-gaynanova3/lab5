package itmo.commands;


import itmo.utils.FormatCommandOutput;

/**
 * класс, описывающий завершение
 */
public class Exit implements UserCommand {

    /**
     * выполнять
     */
    @Override
    public void execute() {
        System.out.println(new FormatCommandOutput(50, this));
        System.exit(0);
    }
}