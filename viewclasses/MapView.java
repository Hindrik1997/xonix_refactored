package xonix.viewclasses;

import xonix.Model;
import xonix.constants.Constants;
import xonix.dataclasses.MonsterBall;
import xonix.dataclasses.TimeTicket;
import xonix.dataclasses.FieldSquare;

/**
 * Represents the map on screen
 * */
public class MapView extends javax.swing.JPanel
{
    private Model lastSetModel = null;


    /**
     * Constructor for the MapView class. Provides the view of the game field on the screen.
     * Is part of the View class
     * @see xonix.View
     * */
    public MapView ()
    {
        super ();
    }


    /**
     * Override of the paint event of the JPanel
     * Draws the actual map on the panel
     * */
    @Override
    public void paint (java.awt.Graphics g)
    {
        super.paint(g);

        if(lastSetModel == null)
            return;

        for (int i = 0; i < Constants.SQUARE_LENGTH; i ++)
            for (int j = 0; j < Constants.SQUARE_LENGTH; j ++)
            {
                FieldSquare fs = lastSetModel.getFieldSquares().elementAt (i, j);
                g.setColor (fs.getColor ());
                g.fillRect (
                        (int) fs.getLocation ().x,
                        (int) fs.getLocation ().y,
                        fs.getWidth(),
                        fs.getHeight()
                );
            }

        if (lastSetModel.getState().isGameOver ())
        {
            java.awt.Font font = new java.awt.Font ("Helvetica", java.awt.Font.BOLD, 18);
            java.awt.FontMetrics metrics = g.getFontMetrics (font);
            g.setColor (java.awt.Color.RED);
            g.setFont (font);
            g.drawString ("GAME OVER",
                    (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - metrics.stringWidth ("GAME OVER")) / 2,
                    (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - metrics.getHeight ()) / 2);
            return;
        }

        for (MonsterBall mb : lastSetModel.getMonsterBalls())
        {
            g.setColor (mb.getColor ());
            g.fillArc ((int) mb.getLocation ().x, (int) mb.getLocation ().y, mb.getWidth(), mb.getHeight(), 0, 360);
        }

        for (TimeTicket tt : lastSetModel.getTimeTickets())
        {
            g.setColor (tt.getColor ());
            g.fillRect ((int) tt.getLocation ().x, (int) tt.getLocation ().y, tt.getWidth (), tt.getHeight ());
        }

        g.setColor (lastSetModel.getCar().getColor ());
        g.fillRect ((int) lastSetModel.getCar().getLocation ().x, (int) lastSetModel.getCar().getLocation ().y, lastSetModel.getCar().getWidth (), lastSetModel.getCar().getHeight ());
    }

    /**
     * Updates the model from which the paint function will update
     * @param model model which will be used for painting
     * */
    public void update (Model model)
    {
        lastSetModel = model;
        this.repaint();
    }
}
