package gui.buttons;

<<<<<<< Updated upstream
import gui.ui.HoverButtonUI;
=======
import gui.ui.UserHoverUI;

import static javax.swing.text.StyleConstants.setIcon;
>>>>>>> Stashed changes

public abstract class UserButton extends BaseButton {

    public UserButton(String text) {
        super(text);
<<<<<<< Updated upstream
        initializeButton();
    }

    private void initializeButton() {
        // Agregar iconos a la caché de imágenes (actualmente no se inicializan)
        setIcon(null);
        setRolloverIcon(null);
        setUI(new HoverButtonUI());
=======
        // Agregamos los iconos a la caché de imágenes.
        setIcon(null);
        setRolloverIcon(null);
        setUI(new UserHoverUI());
>>>>>>> Stashed changes
    }

    @Override
    protected void initIcons() {
        // No se inicializan iconos.
    }
}