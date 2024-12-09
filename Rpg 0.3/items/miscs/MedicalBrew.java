package items.miscs; 
// Define el paquete `items.miscs`, utilizado para organizar esta clase dentro de un módulo específico.

import entities.Player.*; 
// Importa todas las clases del paquete `entities.Player`, necesarias para interactuar con el jugador.

import enums.Stats;

import java.util.HashMap;
// Importa el enum `Stats`, que probablemente define las estadísticas del jugador, como puntos de salud (`HP`).

public abstract class MedicalBrew extends Misc {
    // Declara una clase pública llamada `MedicalBrew` que extiende la clase base `Misc`.
    // Representa un objeto consumible "Breve Médica" que restaura una cantidad fija de salud.

    private final int healingAmount; 
    // Define un atributo constante que especifica la cantidad de salud que restaura este objeto.

    public MedicalBrew() { 
        // Constructor de la clase `MedicalBrew`.
        super("Medical Brew", "Restaura 50 puntos de salud."); 
        // Llama al constructor de la clase padre `Misc` y asigna un nombre y una descripción al objeto.
        this.healingAmount = 50; 
        // Inicializa el atributo `healingAmount` con un valor fijo de 50.
    }


}
