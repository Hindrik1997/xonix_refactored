package xonix.dataclasses;

import xonix.dataclasses.Abstract_classes.MovableColorableBase;

import java.awt.*;
import java.awt.geom.Point2D;

public class TimeTicket extends MovableColorableBase
{
    private int seconds;

    public TimeTicket (final Point2D.Float loc, final Color color, int seconds, final int width, final int height)
    {
        setLocation (loc);
        setColor (color);
        setWidth (width);
        setHeight (height);
        setSeconds (seconds);
    }

    public boolean contains (final java.awt.geom.Point2D.Float that)
    {
        java.awt.geom.Point2D.Float thisLoc = this.getLocation ();
        return that.x >= thisLoc.x && that.x <= thisLoc.x + this.getWidth() && that.y >= thisLoc.y && that.y <= thisLoc.y + this.getHeight ();
    }

    public int getSeconds ()
    {
        return seconds;
    }

    public void setSeconds (int seconds)
    {
        this.seconds = seconds;
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " width=" + width + " height=" + height + " seconds=" + seconds;
    }
}
