package entities.enemy.Enemys;

import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Esta clase representa un enemigo específico en el juego, el T. Rex.
 * Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del T. Rex.
 */
public class Rex extends Enemy {

    // Constructor que inicializa el Rex con sus estadísticas
    public Rex() {
        super("Tyrannosaurus Rex", 200, 70,  "Un dinosaurio carnívoro enorme y extremadamente peligroso.");
        ImageCache.addImage("Rex", "enemies/Rex.png");

    }

    /**
     * Método de ataque que le causa daño al jugador.
     * @param player El jugador que será atacado.
     * @return Mensaje indicando que el T. Rex ataca al jugador con sus enormes dientes.
     */
    @Override
    public String attack(Player player) {
        System.out.println(getName() + " ataca con su enorme mandíbula!");
        player.takeDamage(getAttackPower());  // Usar el poder de ataque de la clase Enemy
        return getName() + " ataca con su enorme mandíbula!";
    }

    // Este método puede ser implementado si deseas que el T. Rex deje loot
    @Override
    public void getLoot() {
        // Implementar lógica para que el T. Rex deje un botín, si corresponde.
    }

    // Inicializar el personaje, si es necesario, para Rex
    @Override
    protected void initCharacter() {
        // Implementar inicialización adicional si es necesario
    }

    /**
     * Método de ataque que interactúa con otros enemigos, pero no se usa para el T. Rex.
     * @param enemy El enemigo con el que interactúa.
     * @return Mensaje vacío.
     */
    @Override
    public String attack(GameCharacter enemy) {
        return "";
    }

    /**
     * Método que obtiene el sprite para representar al T. Rex.
     * @return El sprite del T. Rex.
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Rex");
    }
}
