package items.armaduras;

// La clase 'Skin' representa una armadura específica hecha de pelaje.
// Extiende la clase 'Armor', lo que significa que hereda todas las propiedades y métodos de esta clase base.
public class Skin extends Armor {

    // Constructor de la clase 'Skin'.
    public Skin() {
        // Llama al constructor de la clase base 'Armor' con valores específicos:
        // - El nombre de la armadura se establece como "armadura de pelaje".
        // - El bono de defensa se establece en 25.
        super("armadura de pelaje", 25);
    }
}
