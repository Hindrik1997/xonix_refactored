package xonix.viewclasses;

import xonix.Model;

public class ScoreView extends javax.swing.JPanel
{
    final private javax.swing.JLabel level;
    final private javax.swing.JLabel time;
    final private javax.swing.JLabel lives;
    final private javax.swing.JLabel cscore;
    final private javax.swing.JLabel rscore;

    public ScoreView ()
    {
        this.setLayout (new javax.swing.BoxLayout (this, javax.swing.BoxLayout.X_AXIS));
        this.setBorder (javax.swing.BorderFactory.createEmptyBorder (10, 0, 10, 0));
        level = new javax.swing.JLabel ("");
        this.add (level);
        this.add (javax.swing.Box.createHorizontalGlue ());
        time = new javax.swing.JLabel ("");
        this.add (time);
        this.add (javax.swing.Box.createHorizontalGlue ());
        lives = new javax.swing.JLabel ("");
        this.add (lives);
        this.add (javax.swing.Box.createHorizontalGlue ());
        cscore = new javax.swing.JLabel ("");
        this.add (cscore);
        this.add (javax.swing.Box.createHorizontalGlue ());
        rscore = new javax.swing.JLabel ("");
        this.add (rscore);
    }

    public void update (Model model)
    {
        this.level.setText ("Current level: " + model.getState().getLevel ());
        this.time.setText ("Remaining time: " + (int) model.getState().getClock ());
        this.lives.setText ("Lives left: " + model.getState().getLives ());
        this.cscore.setText ("Current score: " + model.getState().getcscore ());
        this.rscore.setText ("Required score: " + model.getState().getrscore ());
    }
}