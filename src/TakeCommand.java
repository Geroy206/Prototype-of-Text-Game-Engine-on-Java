import java.util.List;

public class TakeCommand implements Command {
    @Override
    public boolean execute(Player player, GameLoop loop, String arg) {
        Location loc = player.getCurrentLocation();
        Inventory locInv = loc.getInventory();
        List<Item> items = locInv.getContents();

        if (items.isEmpty()) {
            System.out.println("В этой локации нет предметов, которые можно взять!\n");
            return true;
        }

        Item itemToTake = null;

        if (arg == null || arg.isEmpty()) {
            itemToTake = items.getFirst();
        } else {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(arg)) {
                    itemToTake = item;
                    break;
                }
            }
        }

        if (itemToTake != null) {
            locInv.removeItem(itemToTake);
            player.getInventory().addItem(itemToTake);
            System.out.println("Вы подобрали: " + itemToTake.getName());
        } else {
            System.out.println("Предмета '" + arg + "' здесь нет.");
        }

        return true;
    }
}
