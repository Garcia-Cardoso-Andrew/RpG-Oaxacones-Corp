package items.armaduras;

// La clase 'Fur' representa una armadura específica hecha de piel.
// Extiende la clase 'Armor', lo que significa que hereda todas las propiedades y métodos de esta clase base.
public class Fur extends Armor {

    // Constructor de la clase 'Fur'.
    public Fur() {
        // Llama al constructor de la clase base 'Armor' con valores específicos:
        // - El nombre de la armadura se establece como "armadura de piel".
        // - El bono de defensa se establece en 30.
        super("armadura de piel", 30);
    }
}
