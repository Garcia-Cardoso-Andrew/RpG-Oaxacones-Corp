package items.armaduras;

// La clase 'Fabric' representa una armadura específica hecha de tela.
// Extiende la clase 'Armor', lo que significa que hereda todas las propiedades y métodos de la misma.
public class Fabric extends Armor {

    // Constructor de la clase 'Fabric'.
    public Fabric() {
        // Llama al constructor de la clase base 'Armor' con valores específicos:
        // - El nombre de la armadura se establece como "armadura de tela".
        // - El bono de defensa se establece en 25.
        super("armadura de tela", 25);
    }
}
