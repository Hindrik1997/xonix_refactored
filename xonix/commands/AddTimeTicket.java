package xonix.commands;

import xonix.Application;
import xonix.Controller;
import xonix.Sounds;
import xonix.constants.Constants;
import xonix.dataclasses.TimeTicket;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Adds time ticket to the game
 * */
public class AddTimeTicket extends Command {

    /**
     * Adds time ticket to the game
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Application.getInstance().getController().getModel().getTimeTickets().add (
                new TimeTicket(
                        new java.awt.geom.Point2D.Float (
                                Application.getInstance().getController().getModel().getRandom().nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15,
                                Application.getInstance().getController().getModel().getRandom().nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15),
                        Constants.TICKET_COLOR,
                        Constants.TTIME_START, 7, 7)
        );
    }
}