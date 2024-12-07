package items.weapons; 
// Define el paquete `items.weapons`, que organiza esta clase dentro del módulo de objetos relacionados con armas.

public class StoneAxe extends Weapon { 
    // Declara una clase pública llamada `StoneAxe` que extiende la clase base `Weapon`.
    // Representa un arma específica: un hacha de piedra.

    public StoneAxe() { 
        // Constructor de la clase `StoneAxe`.
        super("stone ax", 5); 
        // Llama al constructor de la clase base `Weapon` con dos parámetros:
        // - `"stone ax"`: El nombre del arma.
        // - `5`: Un valor que probablemente representa el daño base del arma.
    }
}
