// Armor.java

public class Armor {
    private String name;
    private int defense;
    private ArmorType type;
    private int durability;

    public Armor(String name, int defense, ArmorType type, int durability) {
        this.name = name;
        this.defense = defense;
        this.type = type;
        this.durability = durability;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public ArmorType getType() {
        return type;
    }

    public int getDurability() {
        return durability;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setType(ArmorType type) {
        this.type = type;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    // Reduce la durabilidad de la armadura al recibir daño
    public void takeDamage(int damage) {
        this.durability -= damage;
        if (this.durability < 0) {
            this.durability = 0;
        }
    }

    // Método para reparar la armadura
    public void repair(int amount) {
        this.durability += amount;
        // Aquí podrías agregar un valor máximo de durabilidad si es necesario.
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + name + '\'' +
                ", defense=" + defense +
                ", type=" + type +
                ", durability=" + durability +
                '}';
    }
}
