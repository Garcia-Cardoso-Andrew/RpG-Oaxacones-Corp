package rpg.entities.enemies.carnotaurus;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;

public  class Carnotaurus extends rpg.entities.enemies.Enemy {
    @Override
    public void initCharacter() {

    }

    public Carnotaurus() {
        super("Carnotaurus", 150, 50, 25,"Un depredador con cuernos, fuerte y ágil.");
    }

    @Override
    public void attack(Player player) {
        // Usar getName() si 'name' es privado en Enemy
        System.out.println(getName() + " te embosca con fuerza!");
        player.takeDamage(getAttackPower());  // Usar getAttackPower() si attackPower es privado
    }
}

