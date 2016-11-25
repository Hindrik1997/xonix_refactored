package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

public class IncreaseCarSpeed extends Command {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getCar().setSpeed (Application.getInstance().getController().getModel().getCar().getSpeed () + 5);
    }
}
