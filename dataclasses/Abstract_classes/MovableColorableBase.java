package xonix.dataclasses.Abstract_classes;

import xonix.dataclasses.Interfaces.IColorable;
import xonix.dataclasses.Interfaces.IMoveable;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class MovableColorableBase extends HeightWidthBase implements IColorable,IMoveable {

    protected Color color;
    protected Point2D.Float loc;

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setLocation(Point2D.Float loc) {
        this.loc = loc;
    }

    @Override
    public Point2D.Float getLocation() {
        return loc;
    }
}
