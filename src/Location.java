import java.util.*;

public class Location {
    private final String name;
    private final int ID;
    private LocationStatus status;
    private String description;
    private final List<Location> paths;
    private final Inventory inventory;

    public Location (String name, int ID, LocationStatus status, String description, List<Location> Paths) {
        this.name = name;
        this.ID = ID;
        this.status = status;
        this.description = description;
        this.paths = Objects.requireNonNullElseGet(Paths, ArrayList::new);
        this.inventory = new Inventory(null);
    }

    public String getName() { return name; }

    public int getID() { return ID; }

    public String getDescription() {
        StringBuilder result = new StringBuilder(description);

        if (this.status == LocationStatus.EXPLORED) {
            result.append(" [ИССЛЕДОВАНО]");
        }

        // Получаем список предметов из инвентаря локации
        List<Item> locItems = inventory.getContents();

        if (!locItems.isEmpty()) {
            result.append("\nПредметы в этой локации: ");
            for (int i = 0; i < locItems.size(); i++) {
                result.append(locItems.get(i).getName());

                if (i < locItems.size() - 1) {
                    result.append(", ");
                }
            }
        }
        return result.toString();
    }

    public LocationStatus getStatus() { return status; }

    public List<Location> getPaths() { return Collections.unmodifiableList(paths); }

    public void setDescription(String description) { this.description = description; }

    public void addPath(Location newDestination) {
        if (!paths.contains(newDestination)) {
            paths.add(newDestination);
        }
    }

    public Inventory getInventory() { return inventory; }

    public void setStatus(LocationStatus newStatus) {
        this.status = newStatus;
    }

    public Location handleSelection(int prompt, Map<Integer, Location> choices) {
        if (choices.containsKey(prompt)) {
            return choices.get(prompt);
        }
        return null;
    }
}
