import java.util.HashMap;
public class Personaje {
        private String name;
        private HashMap<Stats, Integer> stats = new HashMap<>();

        public Personaje(String name) {
            this.name = name;
        }

        private String getName() {
            return name;
        }

        public void attack(Enemy enemy) {
            /*
              Lógica para atacar a un enemigo
             Ejemplo:
             enemy.takeDamage(this.stats.get(Stats.ATTACK));
            */
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

        public int getHealth() {
            return this.stats.get("health");
        }

        public void displayInfo() {
            System.out.println("Personaje: " + name + " | Tipo: " + type +  " | Salud: " + this.stats.get("health") + " | Poder de ataque: " + this.stats.get("attackPower") + " | " + description);
        }

    }


