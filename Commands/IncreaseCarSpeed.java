package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Increases car speed
 * */
public class IncreaseCarSpeed extends Command {

    /**
     * Increases car speed
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setSpeed (Application.getInstance().getController().getModel().getCar().getSpeed () + 5);
    }
}
