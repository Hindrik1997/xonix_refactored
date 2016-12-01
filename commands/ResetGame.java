package xonix.commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Resets the game if dead
 * */
public class ResetGame extends Command {

    /**
     * Resets the game if dead
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (Application.getInstance().getController().getModel().getState().isGameOver ())
            Application.getInstance().reset();
    }
}
