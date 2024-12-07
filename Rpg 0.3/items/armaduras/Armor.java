package items.armaduras;

// Importa una enumeración que define categorías de elementos.
import enums.ItemCategory;

// Importa la clase base 'Equipment', de la cual 'Armor' hereda.
import items.Equipment;

// Define la clase abstracta 'Armor', que representa una armadura en el juego.
// Hereda de 'Equipment', lo que significa que es un tipo especializado de equipo.
public abstract class Armor extends Equipment {

    // Atributo final que almacena el bono de defensa proporcionado por la armadura.
    private final int defenseBonus;

    // Constructor de la clase 'Armor'.
    // Recibe como parámetros el nombre de la armadura y su bono de defensa.
    public Armor(String name, int defenseBonus) {
        // Llama al constructor de la clase base 'Equipment' y pasa:
        // - El nombre del equipo.
        // - Un valor entero generado mediante un intento incorrecto de conversión de cadena.
        // - La categoría del equipo, que se establece como 'ItemCategory.Armadura'.
        super(name, Integer.parseInt("Armadura de tipo " + name), ItemCategory.Armadura); 
        this.defenseBonus = defenseBonus; // Inicializa el bono de defensa.
    }

    // Método para obtener el bono de defensa proporcionado por la armadura.
    public int getAttackBonus() {
        return defenseBonus; // Devuelve el valor de 'defenseBonus'.
    }

    // Método para mostrar la información de la armadura en la consola.
    public void displayItemInfo() {
        // Imprime el nombre de la armadura y su bono de defensa.
        System.out.println("Arma: " + getName() + " | Bono de ataque: " + defenseBonus);
    }
}
