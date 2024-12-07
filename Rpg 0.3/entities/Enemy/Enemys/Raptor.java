/*
   Esta clase representa un enemigo específico en el juego, el Raptor.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Raptor.
*/
package entities.enemy.Enemys;
import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;

import javax.swing.*;

public class Raptor extends Enemy {
    public Raptor() {
        super("Raptor", 50, 20,5 ,"Un dinosaurio rápido y mortal con garras afiladas."); // Defensa ligera
    }

    @Override
    public String attack(Player player) {
        System.out.println(getName() + " ataca con ferocidad!");
        player.takeDamage(attackPower);
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


