package rpg.entities;
import rpg.enums.Stats;
import java.util.HashMap;


public abstract class GameCharacter {
    private String name;
    private HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
    }

    protected GameCharacter() {
    }

    public boolean isAlive() {
        return getStats().get(Stats.HP) > 0;
    }

    public void attack(GameCharacter enemy) {
        // Lógica de ataque básica, se puede sobreescribir en clases concretas
        int damage = getStats().get(Stats.ATTACK);
        enemy.getStats().put(Stats.HP, enemy.getStats().get(Stats.HP) - damage);
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