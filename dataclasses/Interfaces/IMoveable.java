package xonix.dataclasses.Interfaces;
import java.awt.geom.Point2D;

public interface IMoveable {

    void setLocation(Point2D.Float loc);
    Point2D.Float getLocation();
}