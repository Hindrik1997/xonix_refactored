package xonix.viewclasses;

import xonix.IModel;
import xonix.Model;
import xonix.ProxyModel;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the part of the window which shows the scores to the player
 * */
public class ScoreView extends javax.swing.JPanel
{
    final private javax.swing.JLabel level;
    final private javax.swing.JLabel time;
    final private javax.swing.JLabel lives;
    final private javax.swing.JLabel cscore;
    final private javax.swing.JLabel rscore;

    /**
     * Constructor of the class that keeps the counters on the screen
     * Part of the View class
     * @see xonix.View
     * */
    public ScoreView ()
    {
        this.setLayout (new javax.swing.BoxLayout (this, javax.swing.BoxLayout.Y_AXIS));
        this.setBorder (javax.swing.BorderFactory.createEmptyBorder (10, 0, 10, 0));
        this.setBackground(new Color(0.1f,0.1f,0.1f));

        JPanel Horiz0 = new JPanel();
        JPanel Horiz1 = new JPanel();
        Horiz0.setBackground(new Color(0.1f,0.1f,0.1f));
        Horiz1.setBackground(new Color(0.1f,0.1f,0.1f));
        Horiz0.setLayout (new javax.swing.BoxLayout (Horiz0, javax.swing.BoxLayout.X_AXIS));
        Horiz1.setLayout (new javax.swing.BoxLayout (Horiz1, javax.swing.BoxLayout.X_AXIS));

        level = new javax.swing.JLabel (" ");
        level.setForeground(new Color(1.0f,1.0f,1.0f));
        Horiz0.add (level);
        time = new javax.swing.JLabel (" ");
        time.setForeground(new Color(1.0f,1.0f,1.0f));
        Horiz0.add (time);
        lives = new javax.swing.JLabel (" ");
        lives.setForeground(new Color(1.0f,1.0f,1.0f));
        Horiz1.add (lives);
        Horiz1.add (javax.swing.Box.createHorizontalGlue ());
        cscore = new javax.swing.JLabel (" ");
        cscore.setForeground(new Color(1.0f,1.0f,1.0f));
        Horiz1.add (cscore);
        Horiz1.add (javax.swing.Box.createHorizontalGlue ());
        rscore = new javax.swing.JLabel (" ");
        rscore.setForeground(new Color(1.0f,1.0f,1.0f));
        Horiz1.add (rscore);

        this.add(Horiz0);
        this.add(Horiz1);
    }

    /**
     * Update function of the score view
     * Updates the scores from the supplied model
     * @param model input model from which the scores will be taken
     * */
    public void update (IModel model)
    {
        this.level.setText (" Current level: " + model.getState().getLevel ());
        this.time.setText (" Remaining time: " + (int) model.getState().getClock ());
        this.lives.setText (" Lives left: " + model.getState().getLives ());
        this.cscore.setText (" Current score: " + model.getState().getcscore ());
        this.rscore.setText (" Required score: " + model.getState().getrscore ());
    }
}