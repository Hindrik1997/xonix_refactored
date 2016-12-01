package xonix.modelclasses;


import xonix.dataclasses.*;
import xonix.dataclasses.Interfaces.IState;

import java.util.ArrayList;
import java.util.Random;

/**
 * Interface class for the model classes
 * */
public interface IModel {

    /**
     * Returns the fieldSquares of the Model
     * @return fieldSquares of this instance
     * */
    FieldSquares getFieldSquares();

    /**
     * Returns the monsterballs of the Model
     * @return monsterballs of this instance
     * */
    ArrayList<MonsterBall> getMonsterBalls();

    /**
     * Returns the timeTickets field of the Model
     * @return timeTickets of this instance
     * */
    ArrayList<TimeTicket> getTimeTickets();

    /**
     * Returns the state field of the Model
     * @return state of this instance
     * */
    IState getState();

    /**
     * Returns the car field of the Model
     * @return car of this instance
     * */
    Car getCar();

    /**
     * Returns the random field of the Model
     * @return random of this instance
     * */
    Random getRandom();



}
