package items.miscs;

// Importa clases relacionadas con el jugador desde el paquete 'entities.Player'.
import entities.Player.*;

// La clase 'BattleTartare' representa un objeto consumible que mejora las estadísticas del jugador temporalmente.
// Extiende la clase base 'Misc', lo que implica que es un elemento misceláneo en el sistema de juego.
public abstract class BattleTartare extends Misc {

    // Atributos finales que definen los efectos del objeto:
    private final int attackBoost;  // Incremento en el ataque.
    private final int defenseBoost; // Incremento en la defensa.
    private final int duration;     // Duración del efecto en turnos.

    // Constructor de la clase 'BattleTartare'.
    public BattleTartare() {
        // Llama al constructor de la clase base 'Misc' para inicializar el nombre y la descripción del objeto.
        super("Battle Tartare", "Aumenta el ataque y la defensa por 3 turnos.");
        this.attackBoost = 10;   // Incremento fijo de ataque.
        this.defenseBoost = 5;   // Incremento fijo de defensa.
        this.duration = 3;       // Duración fija de 3 turnos.
    }
}
