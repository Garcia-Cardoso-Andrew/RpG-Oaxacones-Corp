package interfaces;

/**
 * Interfaz que define los métodos para objetos que pueden ser equipados en el juego
 */
public interface Equipable {
    /**
     * Método para equipar el objeto
     * Implementaciones de esta interfaz deben definir cómo se equipará el objeto
     */
    void equip();

    /**
     * Método para desequipar el objeto
     * Implementaciones de esta interfaz deben definir cómo se desequipará el objeto
     */
    void unequip();
}
