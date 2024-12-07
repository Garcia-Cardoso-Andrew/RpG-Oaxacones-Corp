package gui.labels;

import enums.BarType;

import javax.swing.*;

public class BarLabel extends JLabel {

    private int barValue;
    private final int maxValue;
    private final BarType type;

    public BarLabel(int value, int maxValue, BarType type) {
        this.maxValue = maxValue;
        this.type = type;
        setBarValue(value); // Inicializa el valor de la barra
        setUI(new gui.ui.BarLabel (type)); // Configura la UI de la barra
    }

    public void setBarValue(int value) {
        // Asegúrate de que el valor esté dentro de los límites
        if (value < 0) {
            barValue = 0;
        } else if (value > maxValue) {
            barValue = maxValue;
        } else {
            barValue = value;
        }
        setText(String.format("%d / %d", barValue, maxValue)); // Actualiza el texto mostrado
    }

    public int getBarValue() {
        return barValue; // Getter para el valor de la barra
    }

    public int getMaxValue() {
        return maxValue; // Getter para el valor máximo
    }

    public BarType getType() {
        return type; // Getter para el tipo de barra
    }

    public void updateBar(Integer integer, Integer integer1) {
    }

    // Otros métodos adicionales pueden ser añadidos aquí según sea necesario
}