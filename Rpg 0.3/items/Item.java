package items;

import enums.ItemCategory;
import utils.cache.ImageCache;

import javax.swing.*;
import java.io.Serializable;

/**
 * The type Item.
 */
public abstract class Item implements Serializable {

    /**
     * The Name.
     */
    protected String name;
    protected String iconName;
    /**
     * The Description.
     */
    protected String description;
    /**
     * The Price.
     */
    protected int price;
    /**
     * The Type.
     */
    protected ItemCategory type;

    public Item(ItemCategory itemCategory) {
    }

    public Item() {

    }

    /**
     * Constructor de la clase Item. Inicializa los atributos de la clase mediante
     * la función initItem().
     */


    /**
     * Función que inicializa los atributos de la clase actual.
     * Deberá ser implementada y sobreescrita por las clases hijas.
     */
    protected abstract void initItem();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public ItemCategory getType() {
        return type;
    }

    public ImageIcon getIcon() {
        return new ImageIcon(ImageCache
                .getImage(iconName)
                .getScaledInstance(32, 32, 0));
    }
}
