package items.weapons; 
// Define el paquete `items.weapons`, que agrupa todas las clases relacionadas con armas en el sistema del juego.

public class Sword extends Weapon { 
    // Declara la clase `Sword` (Espada) como una subclase de `Weapon`.
    // Esta clase representa un arma específica, en este caso, una espada.

    public Sword() { 
        // Constructor de la clase `Sword`.
        super("Espada", 20); 
        // Llama al constructor de la clase base `Weapon` con dos parámetros:
        // - `"Espada"`: El nombre del arma.
        // - `20`: El valor que representa el daño base del arma.
    }
}
