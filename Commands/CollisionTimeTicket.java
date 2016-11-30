package xonix.Commands;

import xonix.Application;
import xonix.dataclasses.TimeTicket;

import java.awt.event.ActionEvent;

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
        Application.getInstance().getController().getState().addClock(time);
        Application.getInstance().getController().getModel().removeTicket(ticket);
    }
}