package rpg.entities.enemies;

import rpg.entities.Player;

/* Clase Enemy que representa las estadísticas de los Enemigos */
/* Mantiene las estadísticas de los enemigos, su ataque y su estado actual */
public class Enemy {
    protected String name;
    protected int health;
    protected int attackPower;
    protected String type;
    protected String description;

    /* Constructor para enemigos */
    public Enemy(String name, String type) {
        this.name = name;
        this.type = type;

        // Asignar salud y poder de ataque según el tipo de enemigo
        if (type.equals("Raptor")) {
            this.health = 50; // Salud del Raptor
            this.attackPower = 20; // Poder de ataque del Raptor
            this.description = "Un género de dinosaurios carnívoros bípedos con garras afiladas.";
        } else if (type.equals("Rex")) {
            this.health = 100; // Salud del Rex
            this.attackPower = 40; // Poder de ataque del Rex
            this.description = "Un dinosaurio carnívoro gigante, conocido por su gran fuerza y tamaño.";
        } else if (type.equals("Therizino")) {
            this.health = 80; // Salud del Therizinosaurus
            this.attackPower = 60; // Poder de ataque del Therizinosaurus
            this.description = "Un dinosaurio herbívoro con garras enormes, conocido por su extraño aspecto.";
        } else {
            throw new IllegalArgumentException("Tipo de enemigo no válido");
        }
    }

    // Métodos
    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Player player) { // Cambiado para atacar al jugador
        player.takeDamage(attackPower);
        System.out.println(name + " ataca a " + player.getName() + " por " + attackPower + " de daño!");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0; // Evitar salud negativa
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getType() { // Método para obtener el tipo de enemigo
        return type;
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + name + " | Tipo: " + type + " | " + description + " | Salud: " + health + " | Poder de ataque: " + attackPower);
    }
}
