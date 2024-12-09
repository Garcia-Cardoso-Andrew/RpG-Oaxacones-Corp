package entities;

import java.util.HashMap;
import enums.Stats;

public abstract class GameCharacter {
    protected String name;
    protected HashMap<Stats, Integer> stats; // Usamos el enum Stats

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initCharacter(); // Inicializa los stats del personaje
    }

    // Método abstracto para inicializar el personaje
    protected abstract void initCharacter();

    // Método para verificar si el personaje está vivo
    public boolean isAlive() {
        Integer hp = getStats().get(Stats.HP);
        return hp != null && hp > 0;
    }

    // Método para atacar a otro GameCharacter
    public String attack(GameCharacter enemy) {
        Integer damage = getStats().get(Stats.ATTACK);
        if (damage != null) {
            enemy.takeDamage(damage);
            return name + " ataca a " + enemy.getName() + " causando " + damage + " de daño.";
        }
        return name + " no tiene poder de ataque.";
    }

    // Método para recibir daño (debería ser implementado en las subclases)
    public abstract void takeDamage(int damage);

    // Método para obtener el nombre del personaje
    public String getName() {
        return name;
    }

    // Método para obtener los stats del personaje
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    // Método para mostrar la información del personaje
    public void displayInfo() {
        System.out.println("Nombre: " + name + "\nEstadísticas: " + stats);
    }
}
