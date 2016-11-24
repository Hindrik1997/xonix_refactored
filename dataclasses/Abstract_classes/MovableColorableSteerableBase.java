package xonix.dataclasses.Abstract_classes;

import xonix.constants.Constants;
import xonix.dataclasses.Interfaces.ISteerable;

import java.awt.geom.Point2D;

public abstract class MovableColorableSteerableBase extends MovableColorableBase implements ISteerable {
    protected int heading;
    protected float speed;

    @Override
    public int getHeading() {
        return heading;
    }

    @Override
    public void setHeading(int heading) {
        this.heading = heading;
    }

    @Override
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

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