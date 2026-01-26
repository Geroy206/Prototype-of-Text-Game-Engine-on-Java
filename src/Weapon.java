
public class Weapon extends Item {
    private final float damage;

    public Weapon(String name, int id, String description, float damage) {
        super(name, id, description);
        this.damage = damage;
    }

    public float giveDamage() { return damage; }

    @Override
    public void use() {
        System.out.println("Потом придумаю.");
    }
}
