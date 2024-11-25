/*
   Esta clase representa un enemigo específico en el juego, el Rex.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Rex.
*/
package entities.enemy.Enemys;
import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;

import javax.swing.*;

public class Rex extends Enemy {
    public Rex() {
        super("Rex", 100, 40, 20,"Un dinosaurio rápido y mortal con garras afiladas.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " lanza un poderoso mordisco!");
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

