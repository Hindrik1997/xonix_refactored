package xonix.dataclasses.Abstract_classes;

import xonix.dataclasses.Interfaces.IHeightWidth;


/**
 * Abstract class which implements IHeightWidth
 * Provides default getters and setters
 * @see IHeightWidth
 * */
public class HeightWidthBase implements IHeightWidth{
    protected int width;
    protected int height;

    /**
     * Implements the getter for the height variable
     * @return value
     * */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Implements the setter for the height variable
     * @param height value
     * */
    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Implements the getter for the width variable
     * @return value
     * */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Implements the setter for the width variable
     * @param width value
     * */
    @Override
    public void setWidth(int width) {
        this.width = width;
    }
}
