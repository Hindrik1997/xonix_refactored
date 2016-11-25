package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

public class goNorth extends Command {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setHeading(90);
    }
}
