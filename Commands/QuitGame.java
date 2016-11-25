package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

public class QuitGame extends Command {

    /**
     * Closes the view
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getView().dispatchEvent(new WindowEvent(Application.getInstance().getController().getView(), WindowEvent.WINDOW_CLOSING));
    }
}