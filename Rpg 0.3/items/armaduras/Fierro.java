package items.armaduras;

// La clase 'Fierro' representa una armadura específica hecha de hierro.
// Extiende la clase 'Armor', lo que significa que hereda todas las propiedades y métodos de la misma.
public abstract class Fierro extends Armor {

    // Constructor de la clase 'Fierro'.
    public Fierro() {
        // Llama al constructor de la clase base 'Armor' con valores específicos:
        // - El nombre de la armadura se establece como "fierro".
        // - El bono de defensa se establece en 120.
        super("fierro", 120);
    }
}
