package xonix.strategy;

import xonix.constants.Constants;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

import java.awt.geom.Point2D;

public class HorizontalStrategy implements IStrategy {

    static private HorizontalStrategy instance = new HorizontalStrategy();

    static public IStrategy getInstance()
    {
        return instance;
    }

    @Override
    public Point2D.Float nextLocation(float delta, MovableColorableSteerableBase object) {

        double radians = Math.toRadians (object.getHeading ());

        float newy = object.getLocation().y;

        float newx = object.getLocation ().x + delta * object.getSpeed () * (float) Math.cos (radians);
        if (newx < 0)
            newx = 0;
        else if (newx > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newx = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);

        return new java.awt.geom.Point2D.Float (newx, newy);
    }


}
