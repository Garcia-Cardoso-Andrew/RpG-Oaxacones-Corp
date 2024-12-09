package utils;
// Define el paquete donde se encuentra la interfaz Randomized, en el subpaquete "utils.cache" dentro del proyecto RPG.

public interface Randomized {
// Define la interfaz Randomized, que contiene métodos estáticos para generar números aleatorios.

    /**
     * Método estático que genera un número entero aleatorio entre un rango específico (inclusive).
     * @param min El valor mínimo (inclusive).
     * @param max El valor máximo (inclusive).
     * @return Un número entero aleatorio entre el valor mínimo y el valor máximo.
     */
    static int getRandomInt(int min, int max) {
        // Método estático que devuelve un número aleatorio entre min y max.

        return (int) (Math.random() * (max - min + 1) + min);
        // Usa Math.random() para generar un número aleatorio entre 0 (inclusive) y 1 (exclusive).
        // Luego lo escala al rango (max - min + 1) y le suma el valor mínimo (min) para que el número esté dentro del rango deseado.
    }

    /**
     * Método estático que genera un valor booleano aleatorio (true o false).
     * @return true o false, elegido aleatoriamente.
     */
    static boolean getRandomBoolean() {
        // Método estático que devuelve un valor booleano aleatorio.

        return Math.random() < 0.5;
        // Math.random() genera un número entre 0 y 1. Si el número es menor que 0.5, devuelve true; de lo contrario, devuelve false.
    }
}
