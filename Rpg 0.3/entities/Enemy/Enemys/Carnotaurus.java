package entities.enemy.Enemys;

import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Esta clase representa un enemigo específico en el juego, el Carnotaurus.
 * Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Carnotaurus.
 */
public class Carnotaurus extends Enemy {

    // Constructor que inicializa el Carnotaurus con sus estadísticas
    public Carnotaurus() {
        super("Carnotaurus", 150, 50,  "Un depredador con cuernos, fuerte y ágil.");
    }

    /**
     * Método de ataque que le causa daño al jugador.
     * @param player El jugador que será atacado.
     * @return Mensaje indicando que el Carnotaurus embosca al jugador.
     */
    @Override
    public String attack(Player player) {
        System.out.println(getName() + " te embosca con fuerza!");
        player.takeDamage(getAttackPower());  // Usar el poder de ataque de la clase Enemy
        return getName() + " te embosca con fuerza!";
    }

    // Este método puede ser implementado si deseas que el Carnotaurus deje loot
    @Override
    public void getLoot() {
        // Implementar lógica para que el Carnotaurus deje un botín, si corresponde.
    }

    // Inicializar el personaje, si es necesario, para Carnotaurus
    @Override
    protected void initCharacter() {
        // Implementar inicialización adicional si es necesario
    }

    /**
     * Método de ataque que interactúa con otros enemigos, pero no se usa para el Carnotaurus.
     * @param enemy El enemigo con el que interactúa.
     * @return Mensaje vacío.
     */
    @Override
    public String attack(GameCharacter enemy) {
        return "";
    }

    /**
     * Método que obtiene el sprite para representar al Carnotaurus.
     * @return El sprite del Carnotaurus.
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Carnotaurus");
    }
}
