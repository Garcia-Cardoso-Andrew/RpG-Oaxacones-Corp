package entities.enemy.Enemys;

import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import entities.enemy.EnemyType;
import utils.cache.ImageCache;

import javax.swing.*;
import java.util.Random;

/**
 * Esta clase representa un enemigo específico en el juego, el Raptor.
 * Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Raptor.
 */
public class Raptor extends Enemy {

    private static final Random random = new Random();  // Objeto Random para generar valores aleatorios

    // Constructor que inicializa el Raptor con sus estadísticas y asigna un tipo aleatorio
    public Raptor() {
        // Llamada al constructor de la clase padre con las estadísticas específicas del Raptor
        super("Raptor", 50, 20, "Un dinosaurio rápido y mortal con garras afiladas.");

        // Tipo ya asignado por la clase padre, así que el método getRandomEnemyType() es innecesario.
        // Si deseas asegurarte de que el tipo de enemigo sea aleatorio, mantén el método de la clase padre.
    }

    /**
     * Método de ataque que le causa daño al jugador.
     * @param player El jugador que será atacado.
     * @return Mensaje indicando que el Raptor ataca con ferocidad.
     */
    @Override
    public String attack(Player player) {
        System.out.println(getName() + " ataca con ferocidad!");
        player.takeDamage(attackPower);  // Usar el poder de ataque de la clase Enemy
        return getName() + " ataca con ferocidad!";
    }

    // Este método puede ser implementado si deseas que el Raptor deje loot
    @Override
    public void getLoot() {
        // Implementar lógica para que el Raptor deje un botín, si corresponde.
    }

    // Método para obtener el sprite del Raptor
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Raptor");  // Asegúrate de que esta imagen esté en el directorio correcto
    }

    /**
     *
     */
    @Override
    protected void initCharacter() {

    }
}
