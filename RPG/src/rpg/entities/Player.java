package rpg.entities;
import rpg.enums.Stats;
/**
 * Clase Player que representa al jugador en el juego.
 * Gestiona las estadísticas del jugador, ataques y el estado actual.
 */
import rpg.entities.enemies.Enemy;

import java.util.EnumMap;
import javax.swing.JOptionPane;

//Estadisticas del Jugador
public class Player {

    private String name;
    private EnumMap<rpg.entities.Stats, Integer> stats;

    /* Constructor que inicializa el jugador con su nombre y estadísticas */
    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.stats = new EnumMap<>(rpg.entities.Stats.class); // Usar EnumMap para seguridad de tipo
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
    }

    /* Método getter para obtener el nombre */
    public String getName() {
        return name;
    }

    /* Verificar si el jugador está vivo (salud > 0) */
    public boolean isAlive() {
        return getStat(Stats.HP) > 0; // Usar el método getStat para consistencia
    }

    /* Método para atacar a un enemigo */
    public void attack(Enemy enemy) {
        int attackPower = getStat(Stats.ATTACK);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    /* Método para recibir daño de un enemigo */
    public void takeDamage(int damage) {
        int currentHealth = getStat(Stats.HP);
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0; // Evitar salud negativa
        }
        putStat(Stats.HP, currentHealth); // Usar putStat para consistencia
        JOptionPane.showMessageDialog(null, name + " recibe " + damage + " de daño. Salud restante: " + currentHealth);
    }

    /* Obtener el valor de una estadística específica */
    public int getStat(Stats stat) {
        return stats.get(stat);
    }

    /* Establecer el valor de una estadística específica */
    public void putStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    /* Mostrar la información del jugador en una ventana emergente */
    public void displayInfo() {
        String info = "Jugador: " + name + "\nSalud: " + getStat(Stats.HP) + "\nPoder de ataque: " + getStat(Stats.ATTACK);
        JOptionPane.showMessageDialog(null, info, "Estadísticas del jugador", JOptionPane.INFORMATION_MESSAGE);
    }
}

