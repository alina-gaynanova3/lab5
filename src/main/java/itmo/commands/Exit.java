package itmo.commands;


public class Exit implements UserCommand {

    /**
     * выполнять
     */
    @Override
    public void execute() {
        System.exit(0);
    }
}