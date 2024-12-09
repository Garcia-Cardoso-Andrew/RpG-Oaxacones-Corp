package gui.buttons;

public class ExitButton extends BaseButton {

    public ExitButton() {

        super("Salir");
        addActionListener(e -> System.exit(0));
    }
}
