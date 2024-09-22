class Enemy {
    private String name;
    private int health;
    private int attackPower;
    private String type;
    private String description;

    // Constructor
    public Enemy(String name) {
        this.name = name;
        this.health = 0; // Salud del Raptor
        this.attackPower = 0; // Poder de ataque del Raptor
        this.type = "Raptor";
        this.description = "Un género de dinosaurios carnívoros bípedos con garras afiladas.";
    }

    // Métodos
    public boolean isAlive() {
        return health > 0;
    }

    public void attack(Enemy opponent) {
        opponent.takeDamage(attackPower);
        System.out.println(name + " ataca a " + opponent.getName() + " por " + attackPower + " de daño!");
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0; // Evitar salud negativa
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void displayInfo() {
        System.out.println("Enemigo: " + name + " | Tipo: " + type + " | " + description);
    }
}
