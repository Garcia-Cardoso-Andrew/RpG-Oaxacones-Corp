package items.miscs;
// Paquete donde se encuentra la clase Misc, en el subpaquete "Miscs" dentro de "items".

import items.Item;
// Importa la clase base Item, de la que hereda Misc.

import java.io.Serializable;
// Importa la interfaz Serializable, lo que permite que los objetos de esta clase puedan ser serializados (convertidos en una secuencia de bytes).

/**
 * The type Misc.
 */
// Clase abstracta que representa un tipo de objeto misceláneo en el juego.
public abstract class Misc extends Item implements Serializable {
    // La clase Misc es abstracta, extiende la clase Item, y puede ser serializada.

    /**
     * The Consumable.
     */
    protected boolean consumable;
    // Indica si el objeto es consumible (se consume al usarse).

    /**
     * The Stackable.
     */
    protected boolean stackable;
    // Indica si el objeto es apilable (puede almacenarse en varias cantidades en una misma ranura de inventario).

    protected int quantity;
    // Cantidad actual del objeto.

    protected int maxQuantity;
    // Cantidad máxima que puede tener este objeto en una sola pila.

    public Misc(String battleTartare, String s) {
        // Constructor de la clase Misc.
        super();
        // Llama al constructor de la clase base Item.
        maxQuantity = 99;
        // Establece el valor máximo predeterminado de cantidad apilable en 99.
    }

    /**
     * Use.
     */
    public abstract void use();
    // Método abstracto que define el comportamiento al usar el objeto. Las clases derivadas deben implementar este método.

    public boolean isConsumable() {
        // Método público que devuelve si el objeto es consumible.
        return consumable;
    }

    public boolean isStackable() {
        // Método público que devuelve si el objeto es apilable.
        return stackable;
    }

    public int getQuantity() {
        // Método público que devuelve la cantidad actual del objeto.
        return quantity;
    }

    public void increaseQuantity(int amount) {
        // Método público que incrementa la cantidad del objeto en una cantidad específica.
        quantity += amount;
        // Suma la cantidad especificada al valor actual de quantity.
        if (quantity > maxQuantity) {
            // Si la cantidad resultante es mayor que la cantidad máxima permitida...
            quantity = maxQuantity;
            // ...la cantidad se ajusta al valor máximo permitido.
        }
    }

    public void decreaseQuantity(int amount) {
        // Método público que disminuye la cantidad del objeto en una cantidad específica.
        quantity -= amount;
        // Resta la cantidad especificada al valor actual de quantity.
        if (quantity < 0) {
            // Si la cantidad resultante es menor que 0...
            quantity = 0;
            // ...la cantidad se ajusta a 0 para evitar valores negativos.
        }
    }
}
