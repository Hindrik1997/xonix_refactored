package xonix.dataclasses;

import xonix.constants.Constants;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class representing a field of squares
 * */
public class FieldSquares implements Iterable<FieldSquare>
{
    private final FieldSquare[][] fieldSquares;
    private final Color[][] colors;

    private int x = 0, y = 0;

    /**
     * Sets up the field of squares
     * */
    public FieldSquares ()
    {
        fieldSquares = new FieldSquare[Constants.SQUARE_LENGTH][Constants.SQUARE_LENGTH];
        setFields (Constants.PLAYER_COLOR, Constants.SQUARE_COLOR);
        colors = new Color[Constants.SQUARE_LENGTH][Constants.SQUARE_LENGTH];
    }

    /**
     * Retrieves item at specified indices
     * @param i width index
     * @param j height index
     * @return FieldSquare at indices
     * */
    public FieldSquare elementAt (int i, int j)
    {
        return fieldSquares[i][j];
    }

    /**
     * Resets the field of squares
     * */
    public void reset ()
    {
        setFields (Constants.PLAYER_COLOR, Constants.SQUARE_COLOR);
    }

    /**
     * Sets the color of fields
     * @param inner inner squares their color
     * @param edge edge squares their color
     * */
    private void setFields (Color edge, Color inner)
    {
        for (int y = 0; y < Constants.SQUARE_LENGTH; y ++)
            for (int x = 0; x < Constants.SQUARE_LENGTH; x ++)
                if (x == 0 || y == 0 || x == Constants.SQUARE_LENGTH - 1 || y == Constants.SQUARE_LENGTH - 1)
                    fieldSquares[x][y] = new FieldSquare (new Point2D.Float (x * Constants.SQUARE_UNITS, y * Constants.SQUARE_UNITS), edge, Constants.SQUARE_UNITS);
                else
                    fieldSquares[x][y] = new FieldSquare (new Point2D.Float (x * Constants.SQUARE_UNITS, y * Constants.SQUARE_UNITS), inner, Constants.SQUARE_UNITS);
    }

    /**
     * Fils squares
     * @return number of filled squares
     * */
    public int fillSquares ()
    {
        copyColors ();
        return lineToPlayerColor () + fillAreas ();
    }

    /**
     * Returns number of squares in a line towards the player
     * @return number of squares in a line towards the player
     * */
    private int lineToPlayerColor ()
    {
        int count = 0;
        for (int x = 1; x < Constants.SQUARE_LENGTH - 1; x ++)
            for (int y = 1; y < Constants.SQUARE_LENGTH - 1; y ++)
                if (elementAt (x, y).getColor () == Constants.LINE_COLOR)
                {
                    elementAt (x, y).setColor (Constants.PLAYER_COLOR);
                    count ++;
                }
        return count;
    }

    /**
     * Copies colors to the color array
     * */
    private void copyColors ()
    {
        for (int i = 0; i < Constants.SQUARE_LENGTH; i ++)
            for (int j = 0; j < Constants.SQUARE_LENGTH; j ++)
                colors[i][j] = fieldSquares[i][j].getColor ();
    }

    @Override
    public Iterator<FieldSquare> iterator() {
        return new Iterator<FieldSquare>() {
            @Override
            public boolean hasNext() {
                if(x >= 0 && x < Constants.SQUARE_LENGTH && y >= 0 && y < Constants.SQUARE_LENGTH)
                {
                    return true;
                }
                else
                {
                    x = 0;
                    y = 0;
                    return false;
                }
            }

            @Override
            public FieldSquare next() {

                int _x = x, _y = y;
                if(_x == Constants.SQUARE_LENGTH - 1)
                {
                    x = 0;
                    y++;
                }
                x++;
                return fieldSquares[_x][_y];
            }
        };
    }



    /**
     * Class representing point in 3D space
     * */
    private class Point3D
    {
        private int x, y, z;

        /**
         * Constructor for the point3D
         * @param x x value
         * @param y y value
         * @param z value
         * */
        private Point3D (int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    /**
     * Fills areas
     * @return size of filled area
     * */
    private int fillAreas ()
    {
        ArrayList<Point3D> areas = new ArrayList<> ();
        for (int x = 1; x < Constants.SQUARE_LENGTH - 1; x ++)
            for (int y = 1; y < Constants.SQUARE_LENGTH - 1; y ++)
                if (colors[x][y] == Constants.SQUARE_COLOR)
                    areas.add (new Point3D (x, y, areaSize (x, y)));

        if (areas.size () < 2)
            return 0;

        int max = 0;
        for (int i = 1; i < areas.size (); i ++)
            if (areas.get (i).z > areas.get (max).z)
                max = i;
        areas.remove (max);

        int size = 0;
        for (Point3D area : areas)
        {
            floodfill (area.x, area.y);
            size += area.z;
        }
        return size;
    }

    /**
     * Calculates size of area of same color around x,y
     * @param x x coordinate
     * @param y y coordinate
     * */
    private int areaSize (int x, int y)
    {
        int size = 0;

        java.util.Stack<java.awt.Point> ps = new java.util.Stack<> ();
        ps.push (new java.awt.Point (x, y));

        while (ps.size () != 0)
        {
            java.awt.Point cp = ps.pop ();

            colors[cp.x][cp.y] = Constants.PLAYER_COLOR;

            if (colors[cp.x][cp.y + 1] == Constants.SQUARE_COLOR)
            {
                ps.push (cp);
                ps.push (new java.awt.Point (cp.x, cp.y + 1));
                size ++;
            }
            else if (colors[cp.x + 1][cp.y] == Constants.SQUARE_COLOR)
            {
                ps.push (cp);
                ps.push (new java.awt.Point (cp.x + 1, cp.y));
                size ++;
            }
            else if (colors[cp.x - 1][cp.y] == Constants.SQUARE_COLOR)
            {
                if (colors[cp.x][cp.y - 1] == Constants.SQUARE_COLOR)
                    ps.push (cp);
                ps.push (new java.awt.Point (cp.x - 1, cp.y));
                size ++;
            }
            else if (colors[cp.x][cp.y - 1] == Constants.SQUARE_COLOR)
            {
                ps.push (new java.awt.Point (cp.x, cp.y - 1));
                size ++;
            }
        }
        return size;
    }

    /**
     * Floodfils around x,y
     * @param x x value
     * @param y y value
     * */
    private void floodfill (int x, int y)
    {
        if (elementAt (x, y).getColor () == Constants.PLAYER_COLOR)
            return;
        elementAt (x, y).setColor (Constants.PLAYER_COLOR);
        floodfill (x, y - 1);
        floodfill (x + 1, y);
        floodfill (x, y + 1);
        floodfill (x - 1, y);
    }
}
