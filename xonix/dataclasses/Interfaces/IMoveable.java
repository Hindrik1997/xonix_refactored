package xonix.dataclasses.Interfaces;
import java.awt.geom.Point2D;

/**
 * Represents something that is movable (Has a location)
 * */
public interface IMoveable {

    /**
     * Sets the location
     * @param loc location
     * */
    void setLocation(Point2D.Float loc);


    /**
     * Gets the location
     * @return location
     * */
    Point2D.Float getLocation();
}