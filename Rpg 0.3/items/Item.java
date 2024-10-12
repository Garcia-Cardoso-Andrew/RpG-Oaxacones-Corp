package items;

import enums.ItemType;

public abstract class Item {
    protected String name;
    protected String description;
    protected ItemType itemType;

    public Item(String name, String description, int price, ItemType itemType) {
        this.name = name;
        this.description = description;
        this.itemType = itemType;
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
