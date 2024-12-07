package items.miscs;

// Importa clases relacionadas con el jugador desde el paquete 'entities.Player'.
import entities.Player.*;

// La clase 'BattleTartare' representa un objeto consumible que mejora las estadísticas del jugador temporalmente.
// Extiende la clase base 'Misc', lo que implica que es un elemento misceláneo en el sistema de juego.
public class BattleTartare extends Misc {

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

    // Método para usar el objeto, que aplica sus efectos al jugador.
    public void use(Player player) {
        // Muestra un mensaje indicando los efectos del consumo del objeto.
        System.out.println("Has consumido Battle Tartare. Ataque aumentado en " + attackBoost +
                " y defensa aumentada en " + defenseBoost + " por " + duration + " turnos.");
        // Aquí se implementaría la lógica para aplicar los efectos al jugador:
        // - Aumentar temporalmente las estadísticas del jugador (ataque y defensa).
        // - Implementar un sistema de seguimiento de turnos para eliminar los efectos después de 'duration' turnos.
    }
}
