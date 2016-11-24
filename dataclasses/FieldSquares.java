package xonix.dataclasses;

import xonix.constants.Constants;
import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class FieldSquares
{
    private final FieldSquare[][] fieldSquares;
    private final Color[][] colors;

    public FieldSquares ()
    {
        fieldSquares = new FieldSquare[Constants.SQUARE_LENGTH][Constants.SQUARE_LENGTH];
        setFields (Constants.PLAYER_COLOR, Constants.SQUARE_COLOR);
        colors = new Color[Constants.SQUARE_LENGTH][Constants.SQUARE_LENGTH];
    }

    public FieldSquare elementAt (int i, int j)
    {
        return fieldSquares[i][j];
    }

    public void reset ()
    {
        setFields (Constants.PLAYER_COLOR, Constants.SQUARE_COLOR);
    }

    private void setFields (Color edge, Color inner)
    {
        for (int y = 0; y < Constants.SQUARE_LENGTH; y ++)
            for (int x = 0; x < Constants.SQUARE_LENGTH; x ++)
                if (x == 0 || y == 0 || x == Constants.SQUARE_LENGTH - 1 || y == Constants.SQUARE_LENGTH - 1)
                    fieldSquares[x][y] = new FieldSquare (new Point2D.Float (x * Constants.SQUARE_UNITS, y * Constants.SQUARE_UNITS), edge, Constants.SQUARE_UNITS);
                else
                    fieldSquares[x][y] = new FieldSquare (new Point2D.Float (x * Constants.SQUARE_UNITS, y * Constants.SQUARE_UNITS), inner, Constants.SQUARE_UNITS);
    }

    public int fillSquares ()
    {
        copyColors ();
        return lineToPlayerColor () + fillAreas ();
    }

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

    private void copyColors ()
    {
        for (int i = 0; i < Constants.SQUARE_LENGTH; i ++)
            for (int j = 0; j < Constants.SQUARE_LENGTH; j ++)
                colors[i][j] = fieldSquares[i][j].getColor ();
    }

    private int fillAreas ()
    {
        class Point3D
        {
            private int x, y, z;
            private Point3D (int x, int y, int z)
            {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }
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
