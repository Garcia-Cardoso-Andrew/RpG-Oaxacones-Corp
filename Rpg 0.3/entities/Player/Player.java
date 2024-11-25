/*
   Esta clase representa al jugador en el juego, manejando sus estadísticas como salud, ataque y defensa.
   Utiliza un EnumMap para gestionar las estadísticas del jugador de forma segura y tipada.
   Además, permite que el jugador ataque enemigos, reciba daño y muestre su información.
*/
package entities.Player;
import java.util.EnumMap;
import javax.swing.JOptionPane;
import entities.Enemy.Enemy;
public class Player {
    private final String name;
    private final EnumMap<Stats, Integer> stats;

    /* Constructor que inicializa el jugador con su nombre y estadísticas */
    public Player(String name, int health, int attackPower, int Defense) {
        this.name = name;
        this.stats = new EnumMap<>(Stats.class); // Usar EnumMap para seguridad de tipo
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
        this.stats.put(Stats.DEFENSE,Defense); // Añadir la estadística de defensa
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
        if (!isAlive()) {
            JOptionPane.showMessageDialog(null, name + " no puede atacar porque está muerto!");
            return; // No permite atacar si el jugador está muerto
        }
        int attackPower = getStat(Stats.ATTACK);
        JOptionPane.showMessageDialog(null, name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    /* Método para recibir daño de un enemigo */
    public void takeDamage(int damage) {
        int currentDefense = getStat(Stats.DEFENSE);  // Obtener la defensa actual
        int currentHealth = getStat(Stats.HP);        // Obtener la salud actual

        if (currentDefense > 0) {
            if (currentDefense >= damage) {
                // Si la defensa es suficiente para absorber el daño
                currentDefense -= damage;
                damage = 0;  // Todo el daño fue absorbido por la defensa
            } else {
                // Si la defensa no es suficiente, reducir la defensa a 0 y aplicar el resto a la salud
                damage -= currentDefense;
                currentDefense = 0;
            }
        }

        // Si queda daño después de reducir la defensa, afecta la salud
        if (damage > 0) {
            currentHealth -= damage;
            if (currentHealth < 0) {
                currentHealth = 0;  // Evitar que la salud sea negativa
            }
        }

        // Actualizar las estadísticas
        putStat(Stats.DEFENSE, currentDefense);
        putStat(Stats.HP, currentHealth);

        // Mostrar mensaje con la información del daño y defensa restante
        JOptionPane.showMessageDialog(null, name + " recibe " + damage + " de daño. " +
                "Defensa restante: " + currentDefense + ". Salud restante: " + currentHealth);
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
        String info = "Jugador: " + name + "\nSalud: " + getStat(Stats.HP) +
                "\nPoder de ataque: " + getStat(Stats.ATTACK) +
                "\nDefensa: " + getStat(Stats.DEFENSE);
        JOptionPane.showMessageDialog(null, info, "Estadísticas del jugador", JOptionPane.INFORMATION_MESSAGE);
    }

    public void putStat(enums.Stats stats, int value) {
    }

    public int getStat(enums.Stats stats) {
        return 0;
    }
}

