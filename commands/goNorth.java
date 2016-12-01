package xonix.commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Sets heading north
 * */
public class goNorth extends Command {

    /**
     * Sets heading north
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setHeading(90);
    }
}
