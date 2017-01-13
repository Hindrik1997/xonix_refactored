package xonix.commands;

import xonix.Application;
import xonix.Controller;
import xonix.Sounds;
import xonix.dataclasses.TimeTicket;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CollisionTimeTicket extends Command {

    private TimeTicket ticket;
    private float time;

    public CollisionTimeTicket(float time, TimeTicket ticket)
    {
        this.time = time;
        this.ticket = ticket;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        try {
            Sounds.TimeTicketCollision.play();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }

        Application.getInstance().getController().getState().addClock(time);
        Application.getInstance().getController().getModel().removeTicket(ticket);
    }
}