import java.util.HashMap;
class Enemy {
    private String name;
    private int health;
    private int attackPower;
    private String type;
    private String description;
    private HashMap<String, Integer> stats; // Usamos un HashMap para las estadísticas


    /* Constructor para enemigos */
    public Enemy(String name, String type) {
        this.name = name;
        this.type = type;
        this.stats = new HashMap<>(); // Inicializamos el HashMap


        if (type.equals("Raptor")) {
            this.stats.put("health", 100); // Salud del Raptor
            this.stats.put("attackPower", 20); // Poder de ataque del Raptor
            this.description = "Un género de dinosaurios carnívoros bípedos con garras afiladas.";
        } else if (type.equals("Rex")) {
            this.stats.put("health", 150); // Salud del Rex
            this.stats.put("attackPower", 40); // Poder de ataque del Rex
            this.description = "Un dinosaurio carnívoro gigante, conocido por su gran fuerza y tamaño.";
        } else if (type.equals("Therizino")) {
            this.stats.put("health", 120); // Salud del Therizinosaurus
            this.stats.put("attackPower", 30); // Poder de ataque del Therizinosaurus
            this.description = "Un dinosaurio herbívoro con garras enormes, conocido por su extraño aspecto.";
        } else {
            throw new IllegalArgumentException("Tipo de enemigo no válido");
        }
    }

    // Métodos
    public boolean isAlive() {
         return this.stats.get("health") > 0;
    }

    public void attack(Enemy opponent) {
        int attackPower = this.stats.get("attackPower");
        opponent.takeDamage(attackPower);
        System.out.println(name + " ataca a " + opponent.getName() + " por " + attackPower + " de daño!");
    }

    public void takeDamage(int damage) {
         int currentHealth = this.stats.get("health");
        currentHealth -= damage;
        if (health < 0) health = 0; // Evitar salud negativa
        this.stats.put("health", currentHealth); // Actualizamos el valor en el HashMap

    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return this.stats.get("health");
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + name + " | Tipo: " + type +  " | Salud: " + this.stats.get("health") + " | Poder de ataque: " + this.stats.get("attackPower") + " | " + description);
    }
    
}

