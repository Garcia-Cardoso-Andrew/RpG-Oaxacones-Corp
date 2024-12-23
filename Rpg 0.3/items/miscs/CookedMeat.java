package items.miscs; 
// Define el paquete en el que se encuentra esta clase, utilizado para organizar las clases relacionadas en módulos.

import entities.Player.*; 
// Importa todas las clases públicas del paquete `entities.Player`, necesarias para interactuar con el jugador.

import enums.Stats;

import java.util.HashMap;
// Importa el enum `Stats`, que contiene estadísticas como `HP` (puntos de salud) utilizadas por el jugador.

public abstract class CookedMeat extends Misc {
    // Declara una clase pública llamada `CookedMeat` que extiende de `Misc`.
    // Representa un tipo de objeto consumible que restaura salud al jugador.

    private final int healingAmount; 
    // Variable constante que define la cantidad de salud que se restaura al usar este objeto.

    public CookedMeat() { 
        // Constructor de la clase `CookedMeat`.
        super("Cooked Meat", "Recupera 20 de salud."); 
        // Llama al constructor de la clase base `Misc` con el nombre y la descripción del objeto.
        this.healingAmount = 20; 
        // Inicializa el atributo `healingAmount` con un valor fijo de 20.
    }


}
