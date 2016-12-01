package xonix.strategy;

import xonix.constants.Constants;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

import java.awt.geom.Point2D;

public class VerticalStrategy implements IStrategy {

    static private VerticalStrategy instance = new VerticalStrategy();

    static public IStrategy getInstance()
    {
        return instance;
    }

    @Override
    public Point2D.Float nextLocation(float delta, MovableColorableSteerableBase object) {

        double radians = Math.toRadians (object.getHeading ());

        float newx = object.getLocation().x;

        float newy = object.getLocation ().y - delta * object.getSpeed () * (float) Math.sin (radians);
        if (newy < 0)
            newy = 0;
        else if (newy > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newy = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);

        return new java.awt.geom.Point2D.Float (newx, newy);
    }


}
