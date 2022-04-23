package itmo.commands;


public class Exit implements UserCommand {

    @Override
    public void execute() {
        System.exit(0);
    }
}