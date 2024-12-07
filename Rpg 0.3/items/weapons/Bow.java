package items.weapons; 
// Define el paquete `items.weapons`, que organiza esta clase dentro del módulo de objetos tipo "armas".

public abstract class Bow extends Weapon {
    // Declara una clase pública llamada `Bow` que extiende la clase base `Weapon`.
    // Representa un arma específica, en este caso un arco.

    public Bow() { 
        // Constructor de la clase `Bow`.
        super("Arco", 15); 
        // Llama al constructor de la clase base `Weapon` con dos parámetros:
        // - `"Arco"`: El nombre del arma.
        // - `15`: Un valor que probablemente representa el daño base del arma.
    }
}
