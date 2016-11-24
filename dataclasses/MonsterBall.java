package xonix.dataclasses;

import xonix.constants.Constants;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

/**
 * Class representing a monster in the game
 * */
public class MonsterBall extends MovableColorableSteerableBase
{

    /**
     * Constructor for the monster ball
     * @param heading heading of the ball
     * @param color color of the ball
     * @param loc location of the ball
     * @param radius radius of the ball
     * @param speed speed of the ball
     * */
    public MonsterBall (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final float speed, final int radius)
    {
        setLocation (loc);
        setColor (color);
        setHeading (heading);
        setSpeed (speed);
        setWidth(radius);
        setHeight(radius);
    }

    /**
     * Override
     * @see xonix.dataclasses.Interfaces.ISteerable
     * */
    @Override
    public boolean changeLocation (FieldSquares fss, State state, float delta)
    {
        java.awt.geom.Point2D.Float prev = getLocation ();
        java.awt.geom.Point2D.Float next = nextLocation (delta);
        FieldSquare fsprev = fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5));
        FieldSquare fsnext = fss.elementAt ((int) (next.x / Constants.SQUARE_UNITS + 0.5), (int) (next.y / Constants.SQUARE_UNITS + 0.5));

        if (fsprev.getColor () == Constants.LINE_COLOR || fsnext.getColor () == Constants.LINE_COLOR)
            return true;

        if (fsprev.getColor () != fsnext.getColor ())
        {
            if (fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5)).getColor () != fss.elementAt ((int) (next.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5)).getColor ())
                if (getHeading () < 180)
                    setHeading (180 - getHeading ());
                else
                    setHeading (540 - getHeading ());
            if (fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5)).getColor () != fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (next.y / Constants.SQUARE_UNITS + 0.5)).getColor ())
                setHeading (360 - getHeading ());
        }
        getLocation ().setLocation (nextLocation (delta));
        return false;
    }

    /**
     * Returns string representation of the object
     * @return string represantation
     * */
    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " radius=" + getWidth();
    }
}
