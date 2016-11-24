package xonix.dataclasses;

import xonix.constants.Constants;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

public class Car extends MovableColorableSteerableBase
{
    private int width;
    private int height;

    public Car (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final int speed, final int width, final int height)
    {
        setLocation (loc);
        setColor (color);
        setHeading (heading);
        setSpeed (speed);
        setWidth (width);
        setHeight (height);
    }

    public void reset ()
    {
        setLocation (new java.awt.geom.Point2D.Float (Constants.SQUARE_LENGTH / 2 * Constants.SQUARE_UNITS, (Constants.SQUARE_LENGTH - 1) * Constants.SQUARE_UNITS));
        setColor (Constants.CAR_COLOR);
        setHeading (270);
        setSpeed (50);
        setWidth (Constants.SQUARE_UNITS);
        setHeight (Constants.SQUARE_UNITS);
    }


    public int getWidth ()
    {
        return width;
    }

    public final void setWidth (final int width)
    {
        this.width = width;
    }

    public int getHeight ()
    {
        return height;
    }

    public final void setHeight (final int height)
    {
        this.height = height;
    }

    public boolean changeLocation (FieldSquares fss, State state, float delta)
    {
        java.awt.geom.Point2D.Float prev = getLocation();
        java.awt.geom.Point2D.Float next = nextLocation (delta);
        FieldSquare fsprev = fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5));
        FieldSquare fsnext = fss.elementAt ((int) (next.x / Constants.SQUARE_UNITS + 0.5), (int) (next.y / Constants.SQUARE_UNITS + 0.5));
        if (fsnext.getColor () == Constants.SQUARE_COLOR)
            fsnext.setColor (Constants.LINE_COLOR);
        else if (fsnext.getColor () == Constants.PLAYER_COLOR && fsprev.getColor () == Constants.LINE_COLOR)
            state.addcscore (fss.fillSquares ());
        getLocation ().setLocation (next);
        return true;
    }

    @Override
    public String toString ()
    {
        return "loc=" + getLocation ().x + "," + getLocation ().y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " width=" + width + " height=" + height;
    }
}
