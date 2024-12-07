package items.weapons; 
// Define el paquete `items.weapons`, que organiza esta clase dentro del módulo de objetos tipo "armas".

public abstract class BateBonk extends Weapon {
    // Declara una clase pública llamada `BateBonk` que extiende la clase base `Weapon`.
    // Representa un arma específica llamada "Bate del Cheems".

    public BateBonk() {
        // Constructor de la clase `BateBonk`.
        super("bate del cheems", 206666);
        // Llama al constructor de la clase base `Weapon` y pasa dos parámetros:
        // - `"bate del cheems"`: El nombre del arma.
        // - `206666`: Un valor que representa su daño base o nivel de poder.
    }
}
