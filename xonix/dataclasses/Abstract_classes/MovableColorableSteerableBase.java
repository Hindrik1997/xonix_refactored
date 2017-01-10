package xonix.dataclasses.Abstract_classes;

import xonix.constants.Constants;
import xonix.dataclasses.Interfaces.ISteerable;

import java.awt.geom.Point2D;

/**
 * Abstract class which implements multiple interfaces.
 * Provides default getters and setters for color, height, moving and steering
 * @see MovableColorableBase
 * @see ISteerable
 * */
public abstract class MovableColorableSteerableBase extends MovableColorableBase implements ISteerable {
    protected int heading;
    protected float speed;

    /**
     * Implements the getter for the heading variable
     * @return value
     * */
    @Override
    public int getHeading() {
        return heading;
    }

    /**
     * Implements the setter for the heading variable
     * @param heading value
     * */
    @Override
    public void setHeading(int heading) {
        this.heading = heading;
    }

    /**
     * Implements the setter for the speed variable
     * @param speed value
     * */
    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * Implements the getter for the speed variable
     * @return value
     * */
    @Override
    public float getSpeed() {
        return speed;
    }

    /**
     * Calculates the new position based on the speed,height and heading
     * @param delta current delta time
     * @return returns Point2D representing the new position
     * */
    @Override
    public Point2D.Float nextLocation(float delta) {
        double radians = Math.toRadians (getHeading ());
        float newx = getLocation ().x + delta * getSpeed () * (float) Math.cos (radians);
        if (newx < 0)
            newx = 0;
        else if (newx > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newx = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);
        float newy = getLocation ().y - delta * getSpeed () * (float) Math.sin (radians);
        if (newy < 0)
            newy = 0;
        else if (newy > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newy = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);
        return new java.awt.geom.Point2D.Float (newx, newy);
    }
}