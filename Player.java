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
                /*
              Es para decir que el personaje player "ESTA VIVO" o si ya se nos fue con san pedro
            */
        }

        public void attack(Enemy opponent) {
            int attackPower = this.stats.get("attackPower");
            opponent.takeDamage(attackPower);
            System.out.println(name + " ataca a " + opponent.getName() + " por " + attackPower + " de daño!");
                /*
              para que le de un reverendo golpe al enemigo y se lo mande a san Pedro, o se sigan dando a los batimadrasos
            */
        }

        public void takeDamage(int damage) {
            int currentHealth = this.stats.get("health");
            currentHealth -= damage;
            if (health < 0) health = 0; // Evitar salud negativa
            this.stats.put("health", currentHealth); // Actualizamos el valor en el HashMap
                /*
              Aqui es para que el personaje no se nos haga zombie, con la salud negativa, y si es que
              le parten su mandarina en gajos que se qude bien muerto hasta que el operador del juego decida
              reiniciar o algo asi
            */

        }

        public int getHealth() {
            return this.stats.get("health");
                 /*
              Aqui es para que el programa te diga si el personaje sigue vivo, y aver aguanta unas chelas
            */ 
        }

        public void displayInfo() {
            System.out.println("Personaje: " + name + " | Tipo: " + type +  " | Salud: " + this.stats.get("health") + " | Poder de ataque: " + this.stats.get("attackPower") + " | " + description);
       /*
              Aqui es para que la maquina te diga la informacion del mismo personaje
            */
        }

    }


