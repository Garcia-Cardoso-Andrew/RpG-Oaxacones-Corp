package rpg.entities.enemies.therizino;
import rpg.entities.Player;
import rpg.entities.enemies.Enemy;

public  class Therizino extends rpg.entities.enemies.Enemy {
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
    public void initCharacter() {

    }
}

