package xonix.commands;

import xonix.Application;
import xonix.Controller;
import xonix.Sounds;
import xonix.dataclasses.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.io.IOException;

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

        try {
            Sounds.AddedScore.play();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }

        ((Application.getInstance().getController().getModel().getState())).addcscore(score);
    }
}