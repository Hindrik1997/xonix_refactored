package xonix;

import xonix.dataclasses.*;
import xonix.dataclasses.Interfaces.IState;

import java.util.ArrayList;
import java.util.Random;

public class ProxyModel implements IModel {

    private Model model;

    /**
     * The constructor of the Model class.
     * Represents the data of the game. (MVC Pattern)
     * @see Controller
     * @see View
     * */
    public ProxyModel(Model model)
    {
        this.model = model;
    }

    /**
     * Returns the fieldSquares of the Model
     * @return fieldSquares of this instance
     * */
    public FieldSquares getFieldSquares() {
        return model.getFieldSquares();
    }

    /**
     * Returns the monsterballs of the Model
     * @return monsterballs of this instance
     * */
    public ArrayList<MonsterBall> getMonsterBalls() {
        return model.getMonsterBalls();
    }

    /**
     * Returns the timeTickets field of the Model
     * @return timeTickets of this instance
     * */
    public ArrayList<TimeTicket> getTimeTickets() {
        return model.getTimeTickets();
    }

    /**
     * Returns the state field of the Model
     * @return state of this instance
     * */
    public IState getState() {
        return model.getState();
    }

    /**
     * Returns the car field of the Model
     * @return car of this instance
     * */
    public Car getCar() {
        return model.getCar();
    }

    /**
     * Returns the random field of the Model
     * @return random of this instance
     * */
    public Random getRandom() {
        return model.getRandom();
    }

}
