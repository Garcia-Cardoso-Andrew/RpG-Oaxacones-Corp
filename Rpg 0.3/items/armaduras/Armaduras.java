package items.armaduras;

import enums.ArmorType;
import enums.ItemType;
import items.Equipment;

import java.util.HashMap;

    public abstract class Armor extends Equipment {
        protected ArmorType armorType;

        public Armor(String name, String description, int price, ArmorType armorType) {
            super(name, description, price, ItemType.ARMOR);
            this.armorType = armorType;
        }

        public ArmorType getArmorType() {
            return armorType;
        }
    }

