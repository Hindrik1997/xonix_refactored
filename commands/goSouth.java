package xonix.commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Sets heading south
 * */
public class goSouth extends Command
{
    /**
     * Sets heading south
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setHeading(270);
    }
}
