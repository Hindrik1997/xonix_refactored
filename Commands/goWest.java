package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

/**
 * Sets heading west
 * */
public class goWest extends Command
{
    /**
     * Sets heading west
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setHeading(180);
    }
}
