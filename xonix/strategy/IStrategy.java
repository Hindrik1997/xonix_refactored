package xonix.strategy;

import xonix.dataclasses.Abstract_classes.MovableColorableSteerableBase;

import java.awt.geom.Point2D;

public interface IStrategy {

    static IStrategy getInstance()
    {
        return null;
    }

    Point2D.Float nextLocation(float delta, MovableColorableSteerableBase object);

}
