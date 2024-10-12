package items.armaduras;

import enums.ArmorType;
import enums.ItemType;
import enums.Slot;
import enums.Stats;
import items.Equipment;

import java.util.Map;

public abstract class Armor extends Equipment {
        protected ArmorType armorType;

        public Armor(String name, String description, int price, ArmorType armorType) {
            super(name, price, ItemType.Armadura);
            this.armorType = armorType;
        }

    public Armor(Slot slot, Map<Stats, Integer> stats) {
        super ( slot, stats );
    }

    public ArmorType getArmorType() {
            return armorType;
        }
    }

