package items.miscs; 
// Define el paquete al que pertenece esta clase. Organiza el código en módulos.

import entities.Player.*;
// Importa todas las clases públicas dentro del paquete 'Player', necesarias para interactuar con objetos relacionados al jugador.

import enums.Stats; 
// Importa el enum Stats, que probablemente contiene las estadísticas de un jugador, como HP (puntos de salud).

public abstract class CookedFishMeat extends Misc {
    // Define una clase pública llamada CookedFishMeat que hereda de la clase Misc.
    // Representa un objeto "Carne de pescado cocida" que es un tipo de objeto genérico Misc (probablemente "Misceláneo").

    private final int healingAmount; 
    // Declara una variable de instancia constante que representa la cantidad de salud que este objeto restaura.

    public CookedFishMeat() { 
        // Constructor de la clase. Inicializa los valores para un objeto CookedFishMeat.
        super("Cooked Fish Meat", "Recupera 10 de salud."); 
        // Llama al constructor de la clase padre (Misc) con un nombre y descripción.
        this.healingAmount = 10; 
        // Asigna el valor fijo de 10 al atributo healingAmount.
    }

    public void use(Player player) { 
        // Define un método público que se ejecuta cuando el jugador utiliza este objeto.
        int currentHealth = player.getStats (enums.Stats.HP);
        // Obtiene la salud actual del jugador utilizando su método getStat() y el enum Stats.HP.

        player.putStat(Stats.HP, currentHealth + healingAmount); 
        // Actualiza la salud del jugador sumando el valor de curación (healingAmount) a su salud actual.

        System.out.println("Ha usado una CookedFishMeat. Salud restaurada en " + healingAmount); 
        // Imprime un mensaje en consola informando que se ha utilizado el objeto y la cantidad de salud restaurada.
    }
}
