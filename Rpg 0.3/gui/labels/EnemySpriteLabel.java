package gui.labels;

import entities.Enemy.Enemy;
import gui.ui.EnemyLabelUI;

import javax.swing.*;
import java.awt.*;

public class EnemySpriteLabel extends JLabel {

    ImageIcon icon;
    Enemy enemy;

    public EnemySpriteLabel(Enemy enemy) {

        this.enemy = enemy;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }

    public void initComponents() {

        icon = enemy.getSprite();
        setPreferredSize(getMinDimension());
        setSize(getMinDimension());
        setIcon(icon);
    }

    private Dimension getMinDimension() {

        if (icon.getIconWidth() > 350 || icon.getIconHeight() > 184) {
            icon = new ImageIcon(icon.getImage().getScaledInstance(450, 250, Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(), icon.getIconHeight());
    }
}