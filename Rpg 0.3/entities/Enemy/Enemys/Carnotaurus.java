/*
   Esta clase representa un enemigo específico en el juego, el Carnotaurus.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Carnotaurus.
*/
package entities.Enemy.Enemys;
import entities.GameCharacter;
import entities.Player.Player;
import entities.Enemy.Enemy;

import javax.swing.*;

public class Carnotaurus extends Enemy {
    public Carnotaurus() {
        super("Carnotaurus", 150, 50, 25,"Un depredador con cuernos, fuerte y ágil.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " te embosca con fuerza!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
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

