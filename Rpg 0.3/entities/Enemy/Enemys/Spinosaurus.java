/*
   Esta clase representa un enemigo específico en el juego, el Spinosaurus.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Spinosaurus.
*/
package entities.enemy.Enemys;
import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;
import javax.swing.*;

public class Spinosaurus extends Enemy {
    public Spinosaurus() {
        super("Spinosaurus", 110, 50, 15, "Un dinosaurio rápido y mortal con garras afiladas.");
    }

    @Override
    public String attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " ataca con su gran mandíbula!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
        return null;
    }

    @Override
    public void getLoot() {

    }

    @Override
    protected void initCharacter() {

    }

    @Override
    public String attack(GameCharacter enemy) {
        return "";
    }

    @Override
    public ImageIcon getSprite() {
        return null;
    }
}
