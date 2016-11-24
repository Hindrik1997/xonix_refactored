package xonix.dataclasses.Interfaces;

import java.awt.Color;

/**
 * Interface representing something that can be colored.
 * */
public interface IColorable {

    /**
     * Returns color value
     * @return color
     * */
    Color getColor();

    /**
     * Sets color value
     * @param color value
     * */
    void setColor (final Color color);
}