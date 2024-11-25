package items.weapons;

import enums.ItemCategory;
import items.Equipment;

public abstract class Weapon extends Equipment {
    private final int defenseBonus;

    public Weapon(String name, int attackBonus) {
        super(name, Integer.parseInt ( "Arma de tipo " + name ), ItemCategory.Arma );
        this.defenseBonus = attackBonus;
    }

    public int getAttackBonus() {
        return defenseBonus;
    }

    public void displayItemInfo() {
        System.out.println("Armadura: " + getName() + " | Bono de defensa: " + defenseBonus);
    }
}