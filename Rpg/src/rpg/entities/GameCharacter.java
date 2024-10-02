import java.util.HashMap;
import Rpg.src.rpg.enums.Stats;

public abstract class GameCharacter {
    private String name;
    private HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    public boolean isAlive() {
        return getStats().get(Stats.HEALTH) > 0;
    }

    public void attack(GameCharacter enemy) {
        // Lógica de ataque básica, se puede sobreescribir en clases concretas
        int damage = getStats().get(Stats.ATTACK);
        enemy.getStats().put(Stats.HEALTH, enemy.getStats().get(Stats.HEALTH) - damage);
        System.out.println(name + " ataca a " + enemy.getName() + " por " + damage + " de daño.");
    }

    public String getName() {
        return name;
    }

    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    public abstract void initCharacter();

    // Enum para las estadísticas del personaje

}