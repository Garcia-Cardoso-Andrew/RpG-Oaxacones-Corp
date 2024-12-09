/*
   Esta clase representa al jugador en el juego, manejando sus estadísticas como salud, ataque y defensa.
   Utiliza un EnumMap para gestionar las estadísticas del jugador de forma segura y tipada.
   Además, permite que el jugador ataque enemigos, reciba daño y muestre su información.
*/
package entities.Player;

import entities.GameCharacter;
import enums.Stats;  // Importa las estadísticas del personaje (HP, MP, etc.)
import enums.WearType;  // Importa los tipos de equipo que el personaje puede usar
import exceptions.ItemNotFoundException;  // Importa la excepción que se lanza cuando un objeto no se encuentra en el inventario
import inventory.Inventory;  // Importa la clase que maneja el inventario del personaje
import items.Equipment;  // Importa la clase base para los objetos equipables
import items.Item;  // Importa la clase base para todos los objetos
import items.miscs.Misc;  // Importa la clase que representa objetos misceláneos
import utils.Randomized;  // Importa una clase que genera valores aleatorios

import javax.swing.*;  // Importa componentes gráficos para mostrar diálogos
import java.io.*;  // Importa clases para manejo de archivos y flujo de datos
import java.util.HashMap;  // Importa la clase HashMap para almacenar pares clave-valor

/**
 * El tipo de Jugador.
 */
public  class Player extends GameCharacter implements Serializable {

    private final Inventory inventory;
    private HashMap<WearType, Equipment> equipment;

    /**
     * Constructor que crea un nuevo jugador con el nombre especificado.
     *
     * @param name el nombre del jugador
     * @param i
     * @param i1
     * @param i2
     */
    public Player(String name, int i, int i1, int i2) {

        super(name);
        inventory = new Inventory();
    }

    /**
     * Guarda el estado actual del jugador en un archivo de guardado.
     *
     * @param slot la ranura de guardado (número de archivo)
     */
    public void save(int slot) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("files/save" + slot + ".dat"));
            out.writeObject(this);
            out.close();
            System.out.println("Game saved");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving the game");
        }
    }

    /**
     * Carga el estado del jugador desde un archivo de guardado.
     *
     * @param slot la ranura de guardado (número de archivo)
     * @return el objeto Player cargado o null si ocurre un error
     */
    public static Player load(int slot) {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream
                    ("files/save" + slot + ".dat"));
            Player player = (Player) in.readObject();
            in.close();
            return player;
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading the game");
        }
        return null;
    }

    /**
     * Intenta escapar de una batalla.
     *
     * @return true si logra escapar, false en caso contrario
     */
    public boolean tryToFlee() {

        return Randomized.getRandomBoolean();
    }
    /**
     * Aumenta el nivel del jugador y mejora sus estadísticas.
     */
    public void levelUp() {

        stats.put(Stats.LEVEL, stats.get(Stats.LEVEL) + 1);
        stats.put(Stats.MAX_HP, stats.get(Stats.MAX_HP) + Randomized.getRandomInt(5, 10));
        stats.put(Stats.HP, stats.get(Stats.MAX_HP));
        stats.put(Stats.MAX_MP, stats.get(Stats.MAX_MP) + Randomized.getRandomInt(2, 5));
        stats.put(Stats.MP, stats.get(Stats.MAX_MP));
        stats.put(Stats.ATTACK, stats.get(Stats.ATTACK) + Randomized.getRandomInt(1, 3));
        stats.put(Stats.DEFENSE, stats.get(Stats.DEFENSE) + Randomized.getRandomInt(1, 3));
        stats.put(Stats.NEEDED_EXPERIENCE, stats.get(Stats.NEEDED_EXPERIENCE) + 50);
        stats.put(Stats.EXPERIENCE, 0);
    }

    /**
     * Función sobrescrita que inicializa las características
     * del personaje.
     */
    @Override
    protected void initCharacter() {

        stats.put(Stats.LEVEL, 1);
        stats.put(Stats.MAX_HP, 100);
        stats.put(Stats.HP, 100);
        stats.put(Stats.MAX_MP, 50);
        stats.put(Stats.MP, 50);
        stats.put(Stats.ATTACK, 10);
        stats.put(Stats.DEFENSE, 5);
        stats.put(Stats.EXPERIENCE, 0);
        stats.put(Stats.NEEDED_EXPERIENCE, 100);
        stats.put(Stats.GOLD, 0);
        equipment= new HashMap<>();
        equipment.put(WearType.HEAD, null);
        equipment.put(WearType.CHEST, null);
        equipment.put(WearType.LEGS, null);
        equipment.put(WearType.FEET, null);
        equipment.put(WearType.HANDS, null);
        equipment.put(WearType.WEAPON, null);
    }

    @Override
    public void takeDamage(int damage) {

    }

    /**
     * Añade un objeto al inventario del jugador.
     *
     * @param item el objeto a añadir
     */
    public void addItemToInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                boolean found = false;
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(misc.getName())) {
                        misc.increaseQuantity(1);
                        inventory.removeItem(i);
                        inventory.addItem(misc);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    inventory.addItem(item);
                }
            } else {
                inventory.addItem(item);
            }
        } else {
            inventory.addItem(item);
        }
    }

    /**
     * Elimina un objeto del inventario del jugador.
     *
     * @param item el objeto a eliminar
     */
    public void removeItemFromInventory(Item item) {

        if (item instanceof Misc misc) {
            if (misc.isStackable()) {
                for (Item i : inventory.getMiscs()) {
                    if (i.getName().equals(item.getName())) {
                        misc.decreaseQuantity(1);
                        if (misc.getQuantity() == 0) {
                            inventory.removeItem(i);
                        }
                        break;
                    }
                }
            } else {
                inventory.removeItem(item);
            }
        } else {
            inventory.removeItem(item);
        }
    }

    /**
     * Vende un objeto del inventario del jugador.
     *
     * @param item el objeto a vender
     */
    public void sellItem(Item item) {

        try {
            Item getItem = inventory.getItem(item);
            if (getItem instanceof Misc misc) {
                if (misc.isStackable()) {
                    if (misc.getQuantity() > 1) {
                        misc.decreaseQuantity(1);
                    } else {
                        inventory.removeItem(item);
                    }
                }
            } else {
                inventory.removeItem(getItem);
            }
        } catch (ItemNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Muestra el contenido del inventario en un cuadro de diálogo.
     */
    public void showInventory() {

        StringBuilder content = new StringBuilder("Inventory: \n");
        String format = """
                Name: %s, Price: %d
                Description: %s
                """;
        String formatQuantity = """
                Name: %s, Price: %d, Quantity: %d
                Description: %s
                """;
        // Itera sobre todos los objetos del inventario
        for (Item item : inventory.getItems()) {
            if (item instanceof Misc misc) {  // Si es un objeto misceláneo
                if (misc.isStackable()) {  // Si es apilable
                    content.append(String.format(formatQuantity, item.getName(),
                            item.getPrice(), misc.getQuantity(), item.getDescription()));  // Añade el objeto con su cantidad
                } else {
                    content.append(String.format(format, item.getName(), item.getPrice(),
                            item.getDescription()));  // Añade el objeto sin cantidad
                }
            } else {
                content.append(String.format(format, item.getName(), item.getPrice(),
                        item.getDescription()));  // Añade otros tipos de objetos
            }
        }
        JOptionPane.showMessageDialog(null, content.toString());  // Muestra el contenido del inventario en un cuadro de diálogo
    }

    /**
     * Obtiene el inventario del jugador.
     *
     * @return el inventario del jugador
     */
    public Inventory getInventory() {
        return inventory;  // Retorna el objeto Inventory del jugador
    }


    public void addItemToInventory() {
    }
}