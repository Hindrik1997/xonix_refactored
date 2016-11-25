package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Sets heading east
 * */
public class goEast extends Command {

    /**
     * Sets heading east
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setHeading(0);
    }
}