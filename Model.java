package xonix;

import xonix.constants.Constants;
import xonix.dataclasses.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;


public class Model {

    private final FieldSquares fieldSquares;
    private ArrayList<MonsterBall> monsterBalls;
    private ArrayList<TimeTicket> timeTickets;
    private final Random random;
    private State state;
    private Car car;

    /**
     * The constructor of the Model class.
     * Represents the data of the game. (MVC Pattern)
     * @see Controller
     * @see View
     * */
    public Model()
    {
        fieldSquares = new FieldSquares();
        random = new Random();
        state = new State();
        car = new Car(
                new Point2D.Float (
                        Constants.SQUARE_LENGTH / 2 * Constants.SQUARE_UNITS,
                        (Constants.SQUARE_LENGTH - 1) * Constants.SQUARE_UNITS),
                Constants.CAR_COLOR, 270, 50, Constants.SQUARE_UNITS,
                Constants.SQUARE_UNITS);

        createMonsterballs();
        createTimeTickets();
    }

    /**
     * Creates the monsterballs ArrayList of this instance
     * @see Model()
     * */
    private void createMonsterballs ()
    {
        this.monsterBalls = new ArrayList<> ();
        int number = random.nextInt (10) + 1;
        for (int i = 0; i < number; i ++)
            monsterBalls.add (new MonsterBall (
                    new java.awt.geom.Point2D.Float (
                            random.nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15,
                            random.nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15),
                    Constants.MONSTER_COLOR,
                    random.nextInt (360),
                    random.nextFloat () * 100 + 10, 6)
            );
    }

    /**
     * Creates the timetickets ArrayList of this instance
     * @see Model()
     * */
    private void createTimeTickets()
    {
        this.timeTickets = new ArrayList<> ();
        int number = random.nextInt (Constants.SQUARE_UNITS) + 1;
        for (int i = 0; i < number; i ++)
            timeTickets.add (
                    new TimeTicket (
                            new Point2D.Float (
                                    random.nextInt (
                                       Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15,
                                       random.nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15),
                                        Constants.TICKET_COLOR, Constants.TTIME_START, 7, 7)
            );
    }

    /**
    * Returns the fieldSquares of the Model
    * @return fieldSquares of this instance
    * */
    public FieldSquares getFieldSquares() {
        return fieldSquares;
    }

    /**
     * Returns the monsterballs of the Model
     * @return monsterballs of this instance
     * */
    public ArrayList<MonsterBall> getMonsterBalls() {
        return monsterBalls;
    }

    /**
     * Returns the timeTickets field of the Model
     * @return timeTickets of this instance
     * */
    public ArrayList<TimeTicket> getTimeTickets() {
        return timeTickets;
    }

    /**
     * Returns the state field of the Model
     * @return state of this instance
     * */
    public State getState() {
        return state;
    }

    /**
     * Sets the monsterBalls field of the Model
     * */
    public void setMonsterBalls(ArrayList<MonsterBall> monsterBalls) {
        this.monsterBalls = monsterBalls;
    }

    /**
    * Sets the timeTickets field of the Model
    * */
    public void setTimeTickets(ArrayList<TimeTicket> timeTickets) {
        this.timeTickets = timeTickets;
    }

    /**
     * Sets the state field of the Model
     * */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Returns the car field of the Model
     * @return car of this instance
     * */
    public Car getCar() {
        return car;
    }

    /**
     * Sets the car field of the Model
     * */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Returns the random field of the Model
     * @return random of this instance
     * */
    public Random getRandom() { return random; }

    void reset ()
    {
        fieldSquares.reset ();
        createMonsterballs ();
        createTimeTickets ();
        car.reset ();
        state.reset ();
    }
}