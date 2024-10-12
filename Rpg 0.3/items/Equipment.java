package items;
import java.util.Map;

import enums.*;
public abstract class Equipment extends Item {
    private Slot slot;
    private Map<Stats, Integer> stats;

    public Equipment(Slot slot, Map<Stats, Integer> stats) {
        super ();
        this.slot = slot;
        this.stats = stats;
    }

    public Equipment(String arco, int i, ItemType Arma) {
        super ();
    }

    public Slot getSlot() {
        return slot;
    }


    public Map<Stats, Integer> getStats() {
        return stats;
    }

    public int getStatValue(Stats stat) {
        return stats.get(stat);
    }

    public void setStatValue(Stats stat, int value) {
        stats.put(stat, value);
    }
}