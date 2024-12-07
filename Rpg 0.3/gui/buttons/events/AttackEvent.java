package gui.buttons.events;

import entities.Player.Player;

import entities.enemy.Enemy;
import gui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackEvent implements ActionListener {

    private final MainWindow game;

    public AttackEvent(MainWindow game) {

        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Enemy enemy = this.game.getEnemy();
        Player player = this.game.getPlayer();
        if (enemy != null) {

            this.game.appendText(player.attack(enemy));
            if (enemy.isAlive())
                this.game.appendText(enemy.attack(player));
            this.game.checkGameStatus();
        }
    }
}
