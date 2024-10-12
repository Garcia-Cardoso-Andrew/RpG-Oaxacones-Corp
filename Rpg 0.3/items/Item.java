package items;

import enums.ItemCategory;
import enums.ItemType;

public abstract class Item {
    protected String name;
    protected String description;
    protected ItemType itemType;

    public Item() {
        this.name = name;
        this.itemType = itemType;
    }

    public Item(ItemCategory itemType) {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public ItemType getItemType() {
        return itemType;
    }
}
