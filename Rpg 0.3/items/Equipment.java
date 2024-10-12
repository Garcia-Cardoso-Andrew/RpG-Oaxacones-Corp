package items;
import java.util.HashMap;
import java.util.Map;
import items.Item;
import enums.*;
public abstract class Equipment extends Item {
    private Slot slot;
    private Rarity rarity;
    private Map<Stat, Integer> stats;

    public Equipment(Slot slot, Rarity rarity, Map<Stat, Integer> stats) {
        this.slot = slot;
        this.rarity = rarity;
        this.stats = stats;
    }

    public Slot getSlot() {
        return slot;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public Map<Stat, Integer> getStats() {
        return stats;
    }

    public int getStatValue(Stat stat) {
        return stats.get(stat);
    }

    public void setStatValue(Stat stat, int value) {
        stats.put(stat, value);
    }
}