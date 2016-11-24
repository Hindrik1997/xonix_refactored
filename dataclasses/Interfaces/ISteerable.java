package xonix.dataclasses.Interfaces;

import xonix.dataclasses.FieldSquares;
import xonix.dataclasses.State;

import java.awt.geom.Point2D;

public interface ISteerable {
    int getHeading();
    void setHeading(int heading);

    void setSpeed(float speed);
    float getSpeed();

    Point2D nextLocation(float delta);

    boolean changeLocation (FieldSquares fss, State state, float delta);
}
