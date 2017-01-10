package xonix.dataclasses;
import xonix.dataclasses.Abstract_classes.MovableColorableBase;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * Class representing a square on a field
 * */
public class FieldSquare extends MovableColorableBase
{
    /**
     * Constructor for a fieldsquare
     * @param color color of the square
     * @param loc location of the square
     * @param size size of the square
     * */
    FieldSquare (final Point2D.Float loc, final Color color, int size)
    {
        setLocation (loc);
        setColor (color);
        setWidth(size);
        setHeight(size);
    }

    /**
     * String representation of the fieldsquare
     * @return string representation of this object
     * */
    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " size=" + getWidth();
    }
}