package xonix.commands;

import xonix.Application;
import xonix.constants.Constants;
import java.awt.event.ActionEvent;

/**
 * Updates the game loop
 * */
public class TimeTickUpdate extends Command {

    /**
     * Updates the game loop
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         Application.getInstance().update ((float) (Constants.GAME_TICK_DELAY / 1000.0));
    }
}
