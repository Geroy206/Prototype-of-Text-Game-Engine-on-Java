
public class Enemy extends Entity {
    private final float damage;

    public Enemy(String name, int id, float hp, float damage) {
        super(name, id, hp);
        this.damage = damage;
    }

    public float giveDamage() { return damage; }
}
