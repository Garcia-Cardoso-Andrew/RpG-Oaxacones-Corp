package inventory;

import entities.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The type Inventory test.
 */
public class InventoryTest {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ObjectOutputStream oos = null;
        UIManager.put("OptionPane.messageFont",
                new Font("Arial", Font.BOLD, 20));
        Player player = new Player("Player 1", 100, 30, 50 );
        player.addItemToInventory();
        player.addItemToInventory();
        player.addItemToInventory();
        player.showInventory();
        player.addItemToInventory();
        player.showInventory();
        try {
            oos = new ObjectOutputStream(
                    new FileOutputStream("files/game.dat"));
            oos.writeObject(player);
            oos.close();
        } catch (Exception e) {

        }
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("files/game.dat");
            ois = new ObjectInputStream(fis);
            player.showInventory();
            ois.close();
            fis.close();
            JOptionPane.showMessageDialog(null,
                    "Game loaded successfully");
            JOptionPane.showMessageDialog(null,
                    "Player name: " + player.getName());
            player.showInventory();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "File not found");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
