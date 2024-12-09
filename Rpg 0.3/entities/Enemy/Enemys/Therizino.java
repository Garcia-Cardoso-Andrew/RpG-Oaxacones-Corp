package entities.enemy.Enemys;

import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import utils.cache.ImageCache;

import javax.swing.*;

/**
 * Esta clase representa un enemigo específico en el juego, el Therizino.
 * Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Therizino.
 */
public class Therizino extends Enemy {

    // Constructor que inicializa el Therizino con sus estadísticas
    public Therizino() {
        super("Therizinosaurus", 80, 30, "Un herbívoro gigante con garras enormes.");
        ImageCache.addImage("Therizinosaurus", "enemigos/Therizinosaurus.png");

    }

    /**
     * Método de ataque que le causa daño al jugador.
     * @param player El jugador que será atacado.
     * @return Mensaje indicando que el Therizino ataca al jugador con sus garras.
     */
    @Override
    public String attack(Player player) {
        System.out.println(getName() + " ataca con sus enormes garras!");
        player.takeDamage(getAttackPower());  // Usar el poder de ataque de la clase Enemy
        return getName() + " ataca con sus enormes garras!";
    }

    // Este método puede ser implementado si deseas que el Therizino deje loot
    @Override
    public void getLoot() {
        // Implementar lógica para que el Therizino deje un botín, si corresponde.
    }

    // Inicializar el personaje, si es necesario, para Therizino
    @Override
    protected void initCharacter() {
        // Implementar inicialización adicional si es necesario
    }

    /**
     * Método de ataque que interactúa con otros enemigos, pero no se usa para el Therizino.
     * @param enemy El enemigo con el que interactúa.
     * @return Mensaje vacío.
     */
    @Override
    public String attack(GameCharacter enemy) {
        return "";
    }

    /**
     * Método que obtiene el sprite para representar al Therizino.
     * @return El sprite del Therizino.
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Therizino");
    }
}
