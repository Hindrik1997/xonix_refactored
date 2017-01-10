package xonix.strategy;

import xonix.Application;
import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;
import xonix.dataclasses.Car;

import java.awt.geom.Point2D;

public class ChaseStrategy implements IStrategy {

    static private ChaseStrategy instance = new ChaseStrategy();

    static public IStrategy getInstance()
    {
        return instance;
    }

    @Override
    public Point2D.Float nextLocation(float delta, MovableColorableSteerableBase object) {

        float newx, newy;

        Car c = Application.getInstance().getController().getCar();
        if(c.getLocation().x < object.getLocation().x)
        {
            newx = object.getLocation().x - 1;
        }
        else
            newx = object.getLocation().x + 1;


        if(c.getLocation().y < object.getLocation().y)
        {
            newy = object.getLocation().y - 1;
        }
        else
            newy = object.getLocation().y + 1;

        return new java.awt.geom.Point2D.Float (newx, newy);
    }
}
