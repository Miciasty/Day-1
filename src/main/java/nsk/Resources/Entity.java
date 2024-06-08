package src.main.java.nsk.Resources;

public class Entity {

    protected int health;
    protected int damage;

    public Entity() {
        this.setHealth(5);
        this.setDamage(1);
    }

    public Entity(int h, int d) {
        this.setHealth(h);
        this.setDamage(d);
    }

    protected void setHealth(int h) {
        this.health = h;
    }
    public int getHealth() {
        return this.health;
    }

    protected void setDamage(int d) {
        this.damage = d;
    }
    public int getDamage() {
        return this.damage;
    }

    public String toString(int n) {
        StringBuilder sb = new StringBuilder();

        return String.valueOf(sb.append(this.getClass().getName())
                                .append(": ")
                                .append(n).append(", Health: ")
                                .append(health)
                                .append(", Damage: ")
                                .append(damage)
                                .append("\n"));
    }

}
