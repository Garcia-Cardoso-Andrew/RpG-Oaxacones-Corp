import java.util.EnumMap;

public class Player {

    private String name;
    private EnumMap<Stats, Integer> stats;

    // Constructor that initializes the player with name and stats
    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.stats = new EnumMap<>(Stats.class); // Use EnumMap for type safety
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Check if the player is alive (health > 0)
    public boolean isAlive() {
        return getStat(Stats.HP) > 0; // Use getStat method for consistency
    }

    // Attack an enemy
    public void attack(Enemy enemy) {
        int attackPower = getStat(Stats.ATTACK);
        System.out.println(name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    // Take damage from an enemy
    public void takeDamage(int damage) {
        int currentHealth = getStat(Stats.HP);
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0; // Prevent negative health
        }
        putStat(Stats.HP, currentHealth); // Use putStat method for consistency
        System.out.println(name + " recibe " + damage + " de daño. Salud restante: " + currentHealth);
    }

    // Get the value of a specific stat
    public int getStat(Stats stat) {
        return stats.get(stat);
    }

    // Set the value of a specific stat (consider adding logic for validation if needed)
    public void putStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    // Display the player's information
    public void displayInfo() {
        System.out.println("Jugador: " + name + " | Salud: " + getStat(Stats.HP) + " | Poder de ataque: " + getStat(Stats.ATTACK));
    }

    // Add additional methods as needed (e.g., heal, level up, manage inventory)
}

enum Stats {
    HP,
    ATTACK,
    // Add more stats as needed (e.g., DEFENSE, MANA)
}

