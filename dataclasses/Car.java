package xonix.dataclasses;

import xonix.constants.Constants;

public class Car
{
    private java.awt.geom.Point2D.Float loc;
    private java.awt.Color color;
    private int heading;
    private float speed;
    private int width;
    private int height;

    public Car (final java.awt.geom.Point2D.Float loc, final java.awt.Color color, final int heading, final int speed, final int width, final int height)
    {
        setLocation (loc);
        setColor (color);
        setHeading (heading);
        setSpeed (speed);
        setWidth (width);
        setHeight (height);
    }

    public void reset ()
    {
        setLocation (new java.awt.geom.Point2D.Float (Constants.SQUARE_LENGTH / 2 * Constants.SQUARE_UNITS, (Constants.SQUARE_LENGTH - 1) * Constants.SQUARE_UNITS));
        setColor (Constants.CAR_COLOR);
        setHeading (270);
        setSpeed (50);
        setWidth (Constants.SQUARE_UNITS);
        setHeight (Constants.SQUARE_UNITS);
    }

    public java.awt.geom.Point2D.Float getLocation ()
    {
        return loc;
    }

    public void setLocation (java.awt.geom.Point2D.Float loc)
    {
        this.loc = loc;
    }

    public java.awt.Color getColor ()
    {
        return color;
    }

    public void setColor (final java.awt.Color color)
    {
        this.color = color;
    }

    public int getHeading ()
    {
        return heading;
    }

    public final void setHeading (final int heading)
    {
        this.heading = heading;
    }

    public float getSpeed ()
    {
        return speed;
    }

    public final void setSpeed (final float speed)
    {
        this.speed = speed;
    }

    public int getWidth ()
    {
        return width;
    }

    public final void setWidth (final int width)
    {
        this.width = width;
    }

    public int getHeight ()
    {
        return height;
    }

    public final void setHeight (final int height)
    {
        this.height = height;
    }

    public java.awt.geom.Point2D.Float nextLocation (float delta)
    {
        double radians = Math.toRadians (getHeading ());
        float newx = getLocation ().x + delta * getSpeed () * (float) Math.cos (radians);
        if (newx < 0)
            newx = 0;
        else if (newx > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newx = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);
        float newy = getLocation ().y - delta * getSpeed () * (float) Math.sin (radians);
        if (newy < 0)
            newy = 0;
        else if (newy > Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1))
            newy = Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - (Constants.SQUARE_UNITS - 1);
        return new java.awt.geom.Point2D.Float (newx, newy);
    }

    public void changeLocation (FieldSquares fss, State state, float delta)
    {
        java.awt.geom.Point2D.Float prev = getLocation ();
        java.awt.geom.Point2D.Float next = nextLocation (delta);
        FieldSquare fsprev = fss.elementAt ((int) (prev.x / Constants.SQUARE_UNITS + 0.5), (int) (prev.y / Constants.SQUARE_UNITS + 0.5));
        FieldSquare fsnext = fss.elementAt ((int) (next.x / Constants.SQUARE_UNITS + 0.5), (int) (next.y / Constants.SQUARE_UNITS + 0.5));
        if (fsnext.getColor () == Constants.SQUARE_COLOR)
            fsnext.setColor (Constants.LINE_COLOR);
        else if (fsnext.getColor () == Constants.PLAYER_COLOR && fsprev.getColor () == Constants.LINE_COLOR)
            state.addcscore (fss.fillSquares ());
        getLocation ().setLocation (next);
    }

    @Override
    public String toString ()
    {
        return "loc=" + getLocation ().x + "," + getLocation ().y + " color=[" + color.getRed () + "," + color.getGreen () + "," + color.getBlue () + "]" + " heading=" + heading + " speed=" + speed + " width=" + width + " height=" + height;
    }
}
