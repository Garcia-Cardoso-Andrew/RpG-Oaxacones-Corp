import java.util.EnumMap;

public class Player {

    private String name;
    private EnumMap<Stats, Integer> stats;

    /* Constructor que inicializa el jugador con nombre y estadísticas */
    public Player(String name, int health, int attackPower) {
        this.name = name;
        this.stats = new EnumMap<>(Stats.class); // Usar EnumMap para mayor seguridad de tipos
        this.stats.put(Stats.HP, health);
        this.stats.put(Stats.ATTACK, attackPower);
    }

    /* Getter para el nombre */
    public String getName() {
        return name;
    }

    /* Verificar si el jugador está vivo (salud > 0) */
    public boolean isAlive() {
        return getStat(Stats.HP) > 0; // Usar el método getStat para consistencia
    }

    /* Atacar a un enemigo */
    public void attack(Enemy enemy) {
        int attackPower = getStat(Stats.ATTACK);
        System.out.println(name + " ataca a " + enemy.getName() + " por " + attackPower + " de daño!");
        enemy.takeDamage(attackPower);
    }

    /* Recibir daño de un enemigo */
    public void takeDamage(int damage) {
        int currentHealth = getStat(Stats.HP);
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0; // Prevenir salud negativa
        }
        putStat(Stats.HP, currentHealth); // Usar el método putStat para consistencia
        System.out.println(name + " recibe " + damage + " de daño. Salud restante: " + currentHealth);
    }

    /* Obtener el valor de una estadística específica */
    public int getStat(Stats stat) {
        return stats.get(stat);
    }

    /* Establecer el valor de una estadística específica (considerar añadir lógica de validación si es necesario) */
    public void putStat(Stats stat, int value) {
        stats.put(stat, value);
    }

    /* Mostrar la información del jugador */
    public void displayInfo() {
        System.out.println("Jugador: " + name + " | Salud: " + getStat(Stats.HP) + " | Poder de ataque: " + getStat(Stats.ATTACK));
    }

    /* Añadir métodos adicionales según sea necesario (por ejemplo, curar, subir de nivel, gestionar inventario) */
}

/* Enumeración para las estadísticas del jugador */
enum Stats {
    HP,
    ATTACK,
    /* Añadir más estadísticas según sea necesario (por ejemplo, DEFENSE, MANA) */
}


