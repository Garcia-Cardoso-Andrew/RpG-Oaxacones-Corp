package items;

import enums.ItemCategory;


public abstract class Item {
    protected String name;
    protected String description;
    protected ItemCategory itemCategory;

    public Item() {
        this.name = name;
        this.itemCategory = itemCategory;
    }

    public Item(ItemCategory itemType) {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public ItemCategory getItemType() {
        return itemCategory;
    }
}
