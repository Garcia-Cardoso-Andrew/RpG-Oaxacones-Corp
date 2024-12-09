package items.miscs; 
// Define el paquete al que pertenece esta clase. Organiza el código en módulos.

import entities.Player.*;
// Importa todas las clases públicas dentro del paquete 'Player', necesarias para interactuar con objetos relacionados al jugador.

import enums.Stats;

import java.util.HashMap;
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


}
