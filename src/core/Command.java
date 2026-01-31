package core;

public interface Command {
    boolean execute(Player player,GameLoop loop, String arg);
}