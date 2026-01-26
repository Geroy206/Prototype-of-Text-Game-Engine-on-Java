import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Inventory {
    private final List<Item> contents;

    public Inventory(List<Item> contents) {
        this.contents = Objects.requireNonNullElseGet(contents, ArrayList::new);
    }

    public List<Item> getContents() { return Collections.unmodifiableList(contents); }

    public void addItem(Item newItem) {
        contents.add(newItem);
    }

    public void removeItem(Item toRemove) {
        contents.remove(toRemove);
    }
}
