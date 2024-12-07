package items.weapons; 
// Define el paquete `items.weapons`, organizando todas las clases relacionadas con armas en el sistema del juego.

import enums.ItemCategory; 
// Importa el enum `ItemCategory`, utilizado para clasificar objetos en el juego.

import items.Equipment; 
// Importa la clase `Equipment`, de la cual `Weapon` hereda propiedades y métodos comunes.

public abstract class Weapon extends Equipment { 
    // Declara la clase `Weapon` como abstracta. 
    // Esto significa que no se puede instanciar directamente y debe ser heredada por otras clases específicas como `Sword`, `Axe`, etc.
    // Extiende la clase `Equipment`, lo que sugiere que todas las armas también son equipos en el juego.

    private final int defenseBonus; 
    // Atribut privado y final `defenseBonus`, que almacena el bono de defensa o ataque del arma.
    // Aunque el nombre del atributo sugiere defensa, parece estar relacionado con el bono de ataque.

    public Weapon(String name, int attackBonus) { 
        // Constructor de la clase `Weapon`.
        super(name, Integer.parseInt("Arma de tipo " + name), ItemCategory.Arma);
        this.defenseBonus = attackBonus;
    }
