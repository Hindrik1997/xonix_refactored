package xonix.Commands;

import xonix.Application;

import java.awt.event.ActionEvent;

public class ResetGame extends Command {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (Application.getInstance().getController().getModel().getState().isGameOver ())
            Application.getInstance().reset();
    }
}
