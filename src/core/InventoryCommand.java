package core;

public class InventoryCommand implements Command {
    @Override
    public boolean execute(Player player, GameLoop loop, String arg) {
        loop.setGameState(GameState.IN_INVENTORY);
        return true;
    }
}
