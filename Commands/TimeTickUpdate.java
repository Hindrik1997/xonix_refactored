package xonix.Commands;

import xonix.Application;
import xonix.constants.Constants;
import java.awt.event.ActionEvent;

public class TimeTickUpdate extends Command {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
         Application.getInstance().update ((float) (Constants.GAME_TICK_DELAY / 1000.0));
    }
}
