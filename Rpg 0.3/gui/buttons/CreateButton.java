package gui.buttons;

import gui.buttons.events.NewFileEvent;
import gui.windows.NewFileWindow;
import gui.windows.StartWindow;

public class CreateButton extends UserButton {

    public CreateButton(int slot, NewFileWindow window) {

        super("¡A la aventura!");
        addActionListener(new NewFileEvent(slot, window));
    }
}
