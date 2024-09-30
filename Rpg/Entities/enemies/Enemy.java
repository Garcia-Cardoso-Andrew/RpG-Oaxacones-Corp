public abstract class Enemy {
    private String name;
    private EnemyType type;

    public Enemy(String name) {
        this.name = name;
    }

    public abstract void getLoot();

    public abstract void attack(GameCharacter enemy);

    public EnemyType getType() {
        return type;
    }

    public void setType(EnemyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

