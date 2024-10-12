package items.weapons;

import enums.ItemType;
import enums.WeaponType;
import items.Equipment;

import java.util.HashMap;

public abstract class Weapon extends Equipment {
    protected WeaponType weaponType;

    public Weapon(String name, String description, int price, WeaponType weaponType) {
        super(name, description, price, ItemType.Arma);
        this.weaponType = weaponType;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }
}