package items.weapons;

import enums.ItemType;
import items.Equipment;

public abstract class Weapon extends Equipment {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name, description, Integer.parseInt ( "Arma de tipo " + name ), ItemType.Armadura );
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void displayItemInfo() {
        System.out.println("Arma: " + getName() + " | Bono de ataque: " + attackBonus);
    }
}