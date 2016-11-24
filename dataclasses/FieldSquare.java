package xonix.dataclasses;
import java.awt.Color;
import java.awt.geom.Point2D;

public class FieldSquare
{

    private Point2D.Float loc;
    private Color color;
    private float size;

    FieldSquare (final Point2D.Float loc, final Color color, float size)
    {
        setLocation (loc);
        setColor (color);
        setSize (size);
    }

    public Point2D.Float getLocation ()
    {
        return loc;
    }

    private void setLocation (Point2D.Float loc)
    {
        this.loc = loc;
    }

    public Color getColor ()
    {
        return color;
    }

    void setColor (final Color color)
    {
        this.color = color;
    }

    public float getSize ()
    {
        return size;
    }

    private void setSize (float size)
    {
        this.size = size;
    }

    @Override
    public String toString ()
    {
        return "loc=" + loc.x + "," + loc.y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " size=" + size;
    }
}