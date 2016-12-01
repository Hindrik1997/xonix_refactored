package xonix.commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Decreases car speed
 * */
public class DecreaseCarSpeed extends Command {

    /**
     * Decreases car speed
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setSpeed (Application.getInstance().getController().getModel().getCar().getSpeed () - 5);
    }
}