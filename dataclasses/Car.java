package xonix.dataclasses;

import xonix.constants.Constants;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

/**
 * Represents a car that can be controlled by the player
 * */
public class Car extends MovableColorableSteerableBase
{

    /**
     * Constructor for the Car class
     * @param heading heading of the car
     * @param loc location of the car
     * @param color color of the car
     * @param height height of the car
     * @param width width of the car
     * @param speed speed of the car
     * */
    public Car (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final int speed, final int width, final int height)
    {
        setLocation (loc);
        setColor (color);
        setHeading (heading);
        setSpeed (speed);
        setWidth (width);
        setHeight (height);
    }

    /**
     * Resets the car
     * */
    public void reset ()
    {
        setLocation (new java.awt.geom.Point2D.Float (Constants.SQUARE_LENGTH / 2 * Constants.SQUARE_UNITS, (Constants.SQUARE_LENGTH - 1) * Constants.SQUARE_UNITS));
        setColor (Constants.CAR_COLOR);
        setHeading (270);
        setSpeed (50);
        setWidth (Constants.SQUARE_UNITS);
        setHeight (Constants.SQUARE_UNITS);
    }
    /**
     * See the interface
     * @see xonix.dataclasses.Interfaces.ISteerable
     * */
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

    /**
     * String representation of the object
     * @return string representation of the object
     * */
    @Override
    public String toString ()
    {
        return "loc=" + getLocation ().x + "," + getLocation ().y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " width=" + width + " height=" + height;
    }
}
