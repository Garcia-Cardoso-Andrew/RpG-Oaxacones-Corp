package gui.buttons;

import gui.windows.MainWindow;

public class FleeButton extends UserButton {

    public FleeButton(MainWindow game) {

        super("Huir");
        addActionListener(e -> game.tryToFlee());
    }
}