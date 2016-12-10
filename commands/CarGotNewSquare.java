package xonix.commands;

import xonix.Application;
import xonix.dataclasses.State;

import java.awt.event.ActionEvent;

/**
 * Adds the obtained size of the filled area to the player's score
 * */
public class CarGotNewSquare extends Command {

    int score;

    /**
     * Constructor for the command object to add score
     * @param score score to add
     */
    public CarGotNewSquare(int score)
    {
        this.score = score;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((Application.getInstance().getController().getModel().getState())).addcscore(score);
    }
}