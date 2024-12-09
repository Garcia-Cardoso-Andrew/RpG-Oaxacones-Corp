package gui.buttons.events;

import entities.Player.Player;
import gui.windows.MainWindow;
import gui.windows.NewFileWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFileEvent implements ActionListener {

    int slot;
    NewFileWindow window;

    public NewFileEvent(int slot, NewFileWindow window) {
        this.slot = slot;
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        window.dispose();
        Player player = new Player ( window.getName (), 100, 30, 50 ) {
            @Override
            public void takeDamage(int damage) {

            }
        };
        player.save(slot);
        new MainWindow(player, slot);
    }
}
