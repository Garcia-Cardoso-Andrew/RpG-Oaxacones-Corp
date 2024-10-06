/*
   Esta clase representa un enemigo específico en el juego, el Spinosaurus.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Spinosaurus.
*/
package Enemy.Enemys;
import Player.Player;
import Enemy.Enemy;
public class Spinosaurus extends Enemy {
    public Spinosaurus() {
        super("Spinosaurus", 110, 50, 15, "Un dinosaurio rápido y mortal con garras afiladas.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " ataca con su gran mandíbula!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
    }
}
