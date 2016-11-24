package xonix.dataclasses.Abstract_classes;

import xonix.dataclasses.Interfaces.IHeightWidth;

public class HeightWidthBase implements IHeightWidth{
    protected int width;
    protected int height;

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }
}
