package gui.buttons.events;

import gui.windows.NewFileWindow;
import gui.windows.StartWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPlayerEvent implements ActionListener {
    int slot;
   StartWindow startWindow;

    public NewPlayerEvent(int slot, StartWindow startWindow) {
        this.slot = slot;
        this.startWindow = startWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        startWindow.dispose();
        new NewFileWindow(slot);
    }
}
