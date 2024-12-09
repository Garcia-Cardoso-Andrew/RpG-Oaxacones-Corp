package items.miscs; 
// Define el paquete al que pertenece esta clase, utilizado para organizar el código en módulos lógicos.

import entities.Player.*; 
// Importa todas las clases públicas del paquete `entities.Player`, necesarias para interactuar con el jugador.

public abstract class CookedPrimeMeat extends Misc {
    // Declara una clase pública llamada `CookedPrimeMeat` que extiende la clase `Misc`.
    // Representa un objeto especial de "Carne Premium Cocida", que proporciona mayor curación.

    private final int healingAmount; 
    // Define un atributo constante que indica la cantidad de salud que este objeto restaura.

    public CookedPrimeMeat() { 
        // Constructor de la clase `CookedPrimeMeat`.
        super("Cooked Prime Meat", "Recupera 35 de salud."); 
        // Llama al constructor de la clase base `Misc` con un nombre y una descripción específicos.
        this.healingAmount = 35; 
        // Inicializa el atributo `healingAmount` con un valor fijo de 35.
    }

}
