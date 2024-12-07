package items.miscs; 
// Define el paquete al que pertenece la clase `Misc`. Esto organiza las clases relacionadas con objetos misceláneos.

import enums.ItemCategory; 
// Importa la enumeración `ItemCategory`, que probablemente contiene categorías para clasificar los objetos del juego.

import items.Item; 
// Importa la clase base `Item`, de la cual `Misc` hereda propiedades y comportamientos comunes para todos los objetos.

public abstract class Misc extends Item { 
    // Declara una clase abstracta `Misc` que extiende la clase `Item`.
    // Es abstracta porque probablemente actúa como base para objetos específicos y no se puede instanciar directamente.

    private final boolean consumable; 
    // Atributo booleano que indica si el objeto puede ser consumido (por ejemplo, para restaurar salud).

    private final boolean stackable; 
    // Atributo booleano que indica si el objeto puede apilarse en el inventario (tener múltiples unidades juntas).

    public Misc(String consumable, String stackable) { 
        // Constructor de la clase `Misc`. Recibe los valores como cadenas de texto ("true"/"false").
        super(ItemCategory.Miscelaneo); 
        // Llama al constructor de la clase base `Item` y asigna la categoría del objeto como "Misceláneo".
        this.consumable = Boolean.parseBoolean(consumable); 
        // Convierte el valor de `consumable` de cadena a booleano y lo asigna al atributo correspondiente.
        this.stackable = Boolean.parseBoolean(stackable); 
        // Convierte el valor de `stackable` de cadena a booleano y lo asigna al atributo correspondiente.
    }

    public boolean isConsumable() { 
        // Método público que devuelve si el objeto es consumible.
        return consumable; 
    }

    public boolean isStackable() { 
        // Método público que devuelve si el objeto es apilable.
        return stackable; 
    }
}

