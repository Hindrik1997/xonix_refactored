package xonix.Commands;

import xonix.Application;
import xonix.constants.Constants;
import xonix.dataclasses.TimeTicket;

import java.awt.event.ActionEvent;

public class AddTimeTicket extends Command {
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