package items.miscs;

import items.Item;

public abstract class Misc extends Item {
    private boolean consumable;
    private boolean stackable;

    public Misc(String consumable, String stackable) {
        this.consumable = consumable;
        this.stackable = stackable;
    }

    public boolean isConsumable() {
        return consumable;
    }

    public boolean isStackable() {
        return stackable;
    }

    // Abstract method to be implemented by subclasses
    public abstract void use();
}