package inventory;

// Importa las clases necesarias, incluyendo la clase base 'Item' y sus subclases específicas 'Armor' y 'Misc'.
import items.Item;
import items.armaduras.Armor;
import items.miscs.Misc;

import java.util.ArrayList; // Importa la clase ArrayList para manejar una lista dinámica de elementos.

class Inventory {

    // Lista de elementos en el inventario. Se define como final para indicar que la referencia no cambiará.
    private final ArrayList<Item> items;

    // Capacidad máxima del inventario.
    private int capacity;

    // Constructor que inicializa el inventario con una capacidad especificada.
    public Inventory(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>(); // Crea una nueva lista de elementos vacía.
    }

    // Método para agregar un elemento al inventario.
    public void addItem(Item item) {
        // Verifica si hay espacio disponible antes de agregar el elemento.
        if (items.size() < capacity) {
            items.add(item); // Agrega el elemento a la lista.
        } else {
            System.out.println("Inventory is full"); // Imprime un mensaje si el inventario está lleno.
        }
    }

    // Método para eliminar un elemento específico del inventario.
    public void removeItem(Item item) {
        items.remove(item); // Elimina el elemento de la lista si está presente.
    }

    // Método para obtener un elemento del inventario dado su índice.
    public Item getItem(int index) {
        return items.get(index); // Devuelve el elemento en la posición especificada.
    }

    // Método para obtener el número de elementos en el inventario.
    public void getItemCount() {
        items.size(); // Devuelve el tamaño de la lista (aunque el valor no se utiliza aquí).
    }

    // Método para verificar si el inventario está lleno.
    public boolean isFull() {
        return items.size() == capacity; // Devuelve true si la cantidad de elementos es igual a la capacidad.
    }

    // Método para verificar si el inventario está vacío.
    public boolean isEmpty() {
        return items.isEmpty(); // Devuelve true si la lista de elementos está vacía.
    }

    // Método para vaciar completamente el inventario.
    public void clear() {
        items.clear(); // Limpia todos los elementos de la lista.
    }

    // Método para aumentar la capacidad máxima del inventario.
    public void increaseCapacity(int amount) {
        capacity += amount; // Incrementa la capacidad por la cantidad especificada.
        items.ensureCapacity(capacity); // Asegura que la lista tenga suficiente espacio reservado.
    }

    // Método para obtener una lista de objetos tipo 'Armor' en el inventario.
    public ArrayList<Armor> getArmors() {

        ArrayList<Armor> armors = new ArrayList<>(); // Crea una nueva lista para almacenar armaduras.
        for (Item item : items) {
            if (item instanceof Armor) { // Verifica si el elemento es una instancia de 'Armor'.
                armors.add((Armor) item); // Agrega el elemento a la lista de armaduras.
            }
        }
        return armors; // Devuelve la lista de armaduras.
    }

    // Método para obtener una lista de objetos tipo 'Misc' en el inventario.
    public ArrayList<Misc> getMiscs() {

        ArrayList<Misc> miscs = new ArrayList<>(); // Crea una nueva lista para almacenar objetos misceláneos.
        for (Item item : items) {
            if (item instanceof Misc) { // Verifica si el elemento es una instancia de 'Misc'.
                miscs.add((Misc) item); // Agrega el elemento a la lista de misceláneos.
            }
        }
        return miscs; // Devuelve la lista de misceláneos.
    }
}
