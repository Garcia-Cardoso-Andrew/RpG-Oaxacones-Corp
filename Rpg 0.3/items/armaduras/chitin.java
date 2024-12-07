package items.armaduras;

// La clase 'chitin' representa una armadura específica hecha de quitina (chitin en inglés).
// Extiende la clase 'Armor', lo que significa que hereda todas las propiedades y métodos de esta clase base.
public class chitin extends Armor {

    // Constructor de la clase 'chitin'.
    public chitin() {
        // Llama al constructor de la clase base 'Armor' con valores específicos:
        // - El nombre de la armadura se establece como "armadura de chitin".
        // - El bono de defensa se establece en 43.
        super("armadura de chitin", 43);
    }
}
