public class InventoryCommand implements Command {
    @Override
    public boolean execute(Player player, GameLoop loop) {
        // Переключаем состояние на инвентарь
        loop.gameState = GameState.IN_INVENTORY;
        return true;
    }
}
