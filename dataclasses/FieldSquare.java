package xonix.dataclasses;
import xonix.dataclasses.Abstract_classes.MovableColorableBase;

import java.awt.Color;
import java.awt.geom.Point2D;

public class FieldSquare extends MovableColorableBase
{
    FieldSquare (final Point2D.Float loc, final Color color, int size)
    {
        setLocation (loc);
        setColor (color);
        setWidth(size);
        setHeight(size);
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " size=" + getWidth();
    }
}