package xonix.dataclasses;

import xonix.dataclasses.Abstract_classes.MovableColorableBase;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * TimeTicket class provides a way to represent a item on the screen which once picked up, extends the player's life time
 * */
public class TimeTicket extends MovableColorableBase
{
    private int seconds;

    /**
     * Constructor of the TimeTicket class
     *
     * @param loc location of the ticket
     * @param color color of the ticket
     * @param width width of the ticket
     * @param height height of the ticket
     * @param seconds duration in seconds that the ticket is worth
     * */
    public TimeTicket (final Point2D.Float loc, final Color color, int seconds, final int width, final int height)
    {
        setLocation (loc);
        setColor (color);
        setWidth (width);
        setHeight (height);
        setSeconds (seconds);
    }

    /**
     * Checks if location is inside the ticket
     * @param that location to be checked
     * */
    public boolean contains (final java.awt.geom.Point2D.Float that)
    {
        java.awt.geom.Point2D.Float thisLoc = this.getLocation ();
        return that.x >= thisLoc.x && that.x <= thisLoc.x + this.getWidth() && that.y >= thisLoc.y && that.y <= thisLoc.y + this.getHeight ();
    }

    /**
     * Returns the amount of seconds the ticket is worth
     * */
    public int getSeconds ()
    {
        return seconds;
    }

    /**
     * Sets the amount of seconds the ticket is worth
     * @param seconds amount of seconds
     * */
    public void setSeconds (int seconds)
    {
        this.seconds = seconds;
    }

    /**
     * Returns a string representation of the ticket
     * */
    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " width=" + width + " height=" + height + " seconds=" + seconds;
    }
}
