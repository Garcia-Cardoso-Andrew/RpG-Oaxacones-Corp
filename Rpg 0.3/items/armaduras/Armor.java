package items.armaduras;

import enums.ItemType;
import items.Equipment;

public abstract class Armor extends Equipment {
    private int defenseBonus;

    public Armor(String name, int defenseBonus) {
        super(name, Integer.parseInt ( "Armadura de tipo " + name ), ItemType.Armadura );
        this.defenseBonus = defenseBonus;
    }

    public int getAttackBonus() {
        return defenseBonus;
    }

    public void displayItemInfo() {
        System.out.println("Arma: " + getName() + " | Bono de ataque: " + defenseBonus);
    }
}
