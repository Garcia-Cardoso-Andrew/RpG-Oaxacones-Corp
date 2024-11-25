/*
   Esta clase representa un enemigo específico en el juego, el Therizino.
   Extiende la clase Enemy y personaliza las estadísticas y el comportamiento de ataque del Therizino.
*/

package entities.enemy.Enemys;
import entities.GameCharacter;
import entities.Player.Player;
import entities.enemy.Enemy;

import javax.swing.*;

public class Therizino extends Enemy {
    public Therizino() {
        super("Therizinosaurus", 80, 30, 10, "Un herbívoro gigante con garras enormes.");
    }

    @Override
    public void attack(Player player) {
        // Usar el método getName() para obtener el nombre del enemigo
        System.out.println(getName() + " ataca con sus enormes garras!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() para obtener el poder de ataque
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

