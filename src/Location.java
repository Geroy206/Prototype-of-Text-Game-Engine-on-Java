import java.util.*;

public class Location {
    private final String name;
    private final int ID;
    private LocationStatus status;
    private String description;
    private final List<Location> paths;
    private final List<Item> items;

    public Location (String name, int ID, LocationStatus status, String description, List<Location> Paths, List<Item> Items) {
        this.name = name;
        this.ID = ID;
        this.status = status;
        this.description = description;
        this.paths = Objects.requireNonNullElseGet(Paths, ArrayList::new);
        this.items = Objects.requireNonNullElseGet(Items, ArrayList::new);
    }

    public String getName() { return name; }

    public int getID() { return ID; }

    public String getDescription() {
        StringBuilder result = new StringBuilder(description);

        if (this.status == LocationStatus.EXPLORED) {
            result.append(" [ИССЛЕДОВАНО]");
        }

        if (items != null && !items.isEmpty()) {
            result.append("\nПредметы в этой локации: ");
            for (int i = 0; i < items.size(); i++) {
                result.append(items.get(i).getName());

                if (i < items.size() - 1) {
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

    public void addItem(Item item) {
        items.add(item);
    }

    public void removePath(Location oldDestination) {
        paths.remove(oldDestination);
    }

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
