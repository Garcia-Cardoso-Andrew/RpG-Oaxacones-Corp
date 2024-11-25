package entities;

import entities.Player.Stats;

import java.util.HashMap;

public abstract class GameCharacter {
    protected String name;
    protected HashMap<Stats, Integer> stats;

    public GameCharacter(String name) {
        this.name = name;
        this.stats = new HashMap<>();
        initCharacter(); // Inicializa los stats del personaje
    }

    // Método abstracto para inicializar el personaje
    protected abstract void initCharacter();

    // Método para verificar si el personaje está vivo
    public boolean isAlive() {
        return getStats().get(Stats.HP) > 0; // Asumiendo que hay un stat de salud
    }

    // Método para atacar a otro GameCharacter
    public String attack(GameCharacter enemy) {
        int damage = getStats().get(Stats.ATTACK); // Asumiendo que hay un stat de poder de ataque
        enemy.takeDamage(damage);
        return null;
    }

    // Método para obtener el nombre del personaje
    public String getName() {
        return name;
    }

    // Método para obtener los stats del personaje
    public HashMap<Stats, Integer> getStats() {
        return stats;
    }

    // Método para recibir daño (debería ser implementado en las subclases)
    protected abstract void takeDamage(int damage);
}