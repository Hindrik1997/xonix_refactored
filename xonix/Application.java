package xonix;

import xonix.commands.CollisionMonsterball;
import xonix.commands.CollisionTimeTicket;
import xonix.commands.TimeTickUpdate;
import xonix.constants.Constants;
import xonix.dataclasses.MonsterBall;
import xonix.dataclasses.State;
import xonix.dataclasses.TimeTicket;
import xonix.viewclasses.MapView;
import xonix.viewclasses.ScoreView;

import java.awt.event.ActionEvent;

/**
 * Base class of the application. Is a singleton
 * Manages everything regarding the application and contains the application loop.
 */
public class Application {
    private static Application application = new Application();

    private Model model;
    private View view;
    private Controller controller;

    /**
     * Constructor of the application class.
     * */
    private Application()
    {
        model = new Model();

        ScoreView s = new ScoreView();
        MapView m = new MapView();
        view = new View(m,s);

        setupEvents();
        controller = new Controller(model, view);
    }


    /**
     * Returns the single instance of the xonix.Application class
     * */
    public static Application getInstance()
    {
        return application;
    }

    /**
     * Starts the game loop
     * */
    void play()
    {
        controller.updateScoreView();
        new javax.swing.Timer (Constants.GAME_TICK_DELAY, new TimeTickUpdate()).start ();
    }

    /**
     * Game loop function
     * @param delta delta time since last frame
     * */
    public void update (float delta)
    {
        if ( ! model.getState().isGameOver ())
        {
            (model.getState()).addClock ( - delta);
            for (MonsterBall mb : model.getMonsterBalls())
                if (mb.changeLocation (model.getFieldSquares(), (model.getState()), delta))
                {
                    CollisionMonsterball b = new CollisionMonsterball(mb);
                    b.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                    break;
                }
            model.getCar().changeLocation (model.getFieldSquares(), (model.getState()), delta);
            for (TimeTicket tt : model.getTimeTickets())
                if (tt.contains (model.getCar().getLocation ()))
                {
                    //Execute action
                    CollisionTimeTicket c = new CollisionTimeTicket(tt.getSeconds(), tt);
                    c.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                    break;
                }

        }
        //Updates the state of the model
        model.setState(model.getState());
    }

    /**
     * Resets the model of the controller
     * */
    public void reset ()
    {
        controller.resetModel();
    }

    /**
     * Set up events
     * */
    private void setupEvents()
    {
        view.setupDropDowns();
        view.setupKeys();
    }

    /***
     * Returns the controller of the application
     * @return controller
     */
    public Controller getController()
    {
        return controller;
    }





}
