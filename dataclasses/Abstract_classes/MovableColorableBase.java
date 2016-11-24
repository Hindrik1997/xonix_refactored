package xonix.dataclasses.Abstract_classes;

import xonix.dataclasses.Interfaces.IColorable;
import xonix.dataclasses.Interfaces.IMoveable;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Abstract class which implements multiple interfaces.
 * Provides default getters and setters for color, height and moving
 * @see HeightWidthBase
 * @see IMoveable
 * @see IColorable
 * */
public abstract class MovableColorableBase extends HeightWidthBase implements IColorable,IMoveable {

    protected Color color;
    protected Point2D.Float loc;

    /**
     * Implements the getter for the color variable
     * @return value
     * */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Implements the setter for the color variable
     * @param color value
     * */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Implements the setter for the loc variable
     * @param loc value
     * */
    @Override
    public void setLocation(Point2D.Float loc) {
        this.loc = loc;
    }

    /**
     * Implements the getter for the loc variable
     * @return value
     * */
    @Override
    public Point2D.Float getLocation() {
        return loc;
    }
}
