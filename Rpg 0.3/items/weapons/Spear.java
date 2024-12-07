package items.weapons; 
// Define el paquete `items.weapons`, que organiza esta clase dentro del módulo de objetos relacionados con armas.

public abstract class Spear extends Weapon {
    // Declara una clase pública llamada `Spear` que extiende la clase base `Weapon`.
    // Representa un arma específica: una lanza.

    public Spear() { 
        // Constructor de la clase `Spear`.
        super("Lanza", 18); 
        // Llama al constructor de la clase base `Weapon` con dos parámetros:
        // - `"Lanza"`: El nombre del arma.
        // - `18`: Un valor que probablemente representa el daño base del arma.
    }
}

