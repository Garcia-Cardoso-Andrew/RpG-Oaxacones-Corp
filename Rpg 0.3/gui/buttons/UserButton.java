package gui.buttons;

import gui.ui.HoverButtonUI;

public abstract class UserButton extends BaseButton {

    public UserButton(String text) {
        super(text);
        initializeButton();
    }

    private void initializeButton() {
        // Agregar iconos a la caché de imágenes (actualmente no se inicializan)
        setIcon(null);
        setRolloverIcon(null);
        setUI(new HoverButtonUI());
    }

    @Override
    protected void initIcons() {
        // No se inicializan iconos.
    }
}