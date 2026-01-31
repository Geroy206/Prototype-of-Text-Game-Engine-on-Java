package core;

public class ExitCommand implements Command {
    @Override
    public boolean execute(Player player, GameLoop loop, String arg) {
        return false;
    }
}