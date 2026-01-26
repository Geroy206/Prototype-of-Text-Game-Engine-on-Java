public class InventoryCommand implements Command {
    @Override
    public boolean execute(Player player, GameLoop loop) {
        loop.setGameState(GameState.IN_INVENTORY);
        return true;
    }
}
