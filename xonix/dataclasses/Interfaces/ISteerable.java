package xonix.dataclasses.Interfaces;

import xonix.dataclasses.FieldSquares;
import xonix.dataclasses.State;

import java.awt.geom.Point2D;

/**
 * Represents something that is steerable
 * */
public interface ISteerable {


    /**
     * Getter for a heading value
     * @return value
     * */
    int getHeading();

    /**
     * Setter for the heading value
     * @param heading value
     * */
    void setHeading(int heading);

    /**
     * Setter for the speed value
     * @param speed value
     * */
    void setSpeed(float speed);

    /**
     * Getter for the speed value
     * @return value
     * */
    float getSpeed();

    /**
     * Represents a function that calculates the next position based on the delta time
     * @param delta delta time
     * @return new location as Point2D
     * */
    Point2D nextLocation(float delta);

    /**
     * Represents a way to change te position and returns wether this succeeded or not
     * @param fss field of squares on which to operate
     * @param delta delta tme
     * @param state State of the application
     * @return succeeded or not?
     * */
    boolean changeLocation (FieldSquares fss, State state, float delta);
}
