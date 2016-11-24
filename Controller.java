package xonix;

import xonix.dataclasses.*;

import java.util.ArrayList;
import java.util.Random;


/**
 * Controller class that manages the Model and the View and provides a way to update/modify them
 * Part of the MVC Pattern
 * @see Model
 * @see View
 * */
public class Controller {

    private Model model;
    private View view;

    /**
     * Controller constructor. Requires a Model and a View
     * @param model model the controller will own
     * @param view view the controller will own
     * @see Model
     * @see View
     * */
    public Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
    }

    /**
     * Updates only the mapView of the View attached to the controller
     * */
    public void updateMapView()
    {
        view.updateMapView(model);
    }

    /**
     * Updates only the scoreView of the View attached to the controller
     * */
    public void updateScoreView()
    {
        view.updateScoreView(model);
    }

    /**
     * Updates the complete view attached to the controller
     * */
    public void updateView()
    {
        view.updateMapView(model);
        view.updateScoreView(model);
    }

    /**
     * Resets the model the controller owns
     */
    public void resetModel()
    {
        model.reset ();
    }

    /**
     * Returns the fieldSquares of the Model
     * @return fieldSquares of the model in this controller instance
     * */
    public FieldSquares getFieldSquares() {
        return model.getFieldSquares();
    }

    /**
     * Returns the monsterballs of the Model
     * @return monsterballs of the model in this controller instance
     * */
    public ArrayList<MonsterBall> getMonsterBalls() {
        return model.getMonsterBalls();
    }

    /**
     * Returns the timeTickets field of the Model
     * @return timeTickets of the model in this controller instance
     * */
    public ArrayList<TimeTicket> getTimeTickets() {
        return model.getTimeTickets();
    }

    /**
     * Returns the state field of the Model
     * @return state of the model in this controller instance
     * */
    public State getState() {
        return model.getState();
    }

    /**
     * Returns the car field of the Model
     * @return car of the model in this controller instance
     * */
    public Car getCar() {
        return model.getCar();
    }

    /**
     * Returns the random field of the Model
     * @return random of the model in this controller instance
     * */
    public Random getRandom() { return model.getRandom(); }


}
