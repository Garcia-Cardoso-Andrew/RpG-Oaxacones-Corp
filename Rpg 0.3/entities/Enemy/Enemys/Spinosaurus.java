package entities.enemy.Enemys;

import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import entities.enemy.EnemyType;
import utils.cache.ImageCache;

import javax.swing.*;
import java.util.Random;

/**
 * Esta clase representa un enemigo específico en el juego, el Spinosaurus.
 * Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Spinosaurus.
 */
public class Spinosaurus extends Enemy {

    private static final Random random = new Random();  // Objeto Random para generar valores aleatorios

    // Constructor que inicializa el Spinosaurus con sus estadísticas y asigna un tipo aleatorio
    public Spinosaurus() {
        // Llamada al constructor de la clase padre con las estadísticas específicas del Spinosaurus
        super("Spinosaurus", 110, 50,  "Un dinosaurio rápido y mortal con garras afiladas.");
        ImageCache.addImage("Spinosaurus", "enemigos/Spinosaurus.png");


        // Asignación aleatoria del tipo de enemigo (BASIC, ALPHA, BOSS)
        EnemyType randomType = getRandomEnemyType();
        setType(randomType);
    }

    /**
     * Método que genera un tipo aleatorio para el enemigo.
     * @return Tipo aleatorio: BASIC, ALPHA, o BOSS.
     */
    private EnemyType getRandomEnemyType() {
        // Genera un número aleatorio entre 0 y 2
        int randomIndex = random.nextInt(3);

        switch (randomIndex) {
            case 0:
                return EnemyType.BASIC;
            case 1:
                return EnemyType.ALPHA;
            case 2:
                return EnemyType.BOSS;
            default:
                return EnemyType.BASIC;  // Por defecto, se asigna el tipo BASIC
        }
    }

    /**
     * Método de ataque que le causa daño al jugador.
     * @param player El jugador que será atacado.
     * @return Mensaje indicando que el Spinosaurus ataca al jugador con su gran mandíbula.
     */
    @Override
    public String attack(Player player) {
        System.out.println(getName() + " ataca con su gran mandíbula!");
        player.takeDamage(getAttackPower());  // Usar el poder de ataque de la clase Enemy
        return getName() + " ataca con su gran mandíbula!";
    }

    // Este método puede ser implementado si deseas que el Spinosaurus deje loot
    @Override
    public void getLoot() {
        // Implementar lógica para que el Spinosaurus deje un botín, si corresponde.
    }

    // Inicializar el personaje, si es necesario, para Spinosaurus
    @Override
    protected void initCharacter() {
        // Implementar inicialización adicional si es necesario
    }

    /**
     * Método de ataque que interactúa con otros enemigos, pero no se usa para Spinosaurus.
     * @param enemy El enemigo con el que interactúa.
     * @return Mensaje vacío.
     */
    @Override
    public String attack(GameCharacter enemy) {
        return "";
    }

    /**
     * Método que obtiene el sprite para representar al Spinosaurus.
     * @return El sprite del Spinosaurus.
     */
    @Override
    public ImageIcon getSprite() {
        return ImageCache.getImageIcon("Spinosaurus");
    }
}
