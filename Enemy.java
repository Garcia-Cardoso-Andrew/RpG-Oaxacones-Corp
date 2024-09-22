class Enemy {
    private String name;
    private int health;
    private int attackPower;
    private String type;
    private String description;

    /* Constructor para enemigos */
    public Enemy(String name, String type) {
        this.name = name;
        this.type = type;

        if (type.equals("Raptor")) {
            this.health = 0; // Salud del Raptor
            this.attackPower = 0; // Poder de ataque del Raptor
            this.description = "Un género de dinosaurios carnívoros bípedos con garras afiladas.";
        } else if (type.equals("Rex")) {
            this.health = 0; // Salud del Rex
            this.attackPower = 0; // Poder de ataque del Rex
            this.description = "Un dinosaurio carnívoro gigante, conocido por su gran fuerza y tamaño.";
        } else if (type.equals("Therizino")) {
            this.health = 0; // Salud del Therizinosaurus
            this.attackPower = 0; // Poder de ataque del Therizinosaurus
            this.description = "Un dinosaurio herbívoro con garras enormes, conocido por su extraño aspecto.";
        } else {
            throw new IllegalArgumentException("Tipo de enemigo no válido");
        }
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

