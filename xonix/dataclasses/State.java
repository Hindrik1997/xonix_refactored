package xonix.dataclasses;

import xonix.Application;
import xonix.constants.Constants;
import xonix.dataclasses.Interfaces.IState;

/**
 * Object representing state of the current game
 * */
public class State implements IState
{
    private int level;
    private float clock;
    private int lives;
    private int cscore;
    private int rscore;
    private int tTime;
    private boolean gameOver;

    /**
     * Constructor, resets to default
     * */
    public State ()
    {
        this.reset ();
    }

    /**
     * Sets level to level 1
     * */
    public void reset ()
    {
        setLevel (1);
    }

    /**
     * Returns current level
     * @return current level
     * */
    public int getLevel ()
    {
        return level;
    }

    /**
     * Sets current level based on the int and some xonix.constants
     * @see Constants
     * @param level int indicating the new level
     * */
    public void setLevel (int level)
    {
        this.level = level;
        this.clock = (6 - level) * 10;
        this.lives = Constants.LIVES_START;
        this.cscore = Constants.CSCORE_START;
        this.rscore = Constants.RSCORE_START;
        this.tTime = level * 2 - 1;
        this.gameOver = false;
    }

    /**
     * Returns the clock float value
     * @return value
     * */
    public float getClock ()
    {
        return clock;
    }

    /**
     * Sets the clock value
     * @param clock value
     * */
    public void setClock (float clock)
    {
        this.clock = clock;
        if ((int)clock == 0)
        {
            decLives ();
            this.clock = (6 - level) * 2;
        }
    }

    /**
     * Adds to the current clock value
     * @param clock delta time to add
     * */
    public void addClock (float clock)
    {
        setClock (this.clock + clock);
    }

    /**
     * Returns amount of lives
     * @return amount of lives
     * */
    public int getLives ()
    {
        return lives;
    }

    /**
     * Sets lives amount
     * @param lives new live amount
     * */
    public void setLives (int lives)
    {
        this.lives = lives;
    }

    /**
     * decreases live amount
     * */
    public void decLives ()
    {
        setLives (getLives () - 1);
        if (getLives () == 0)
            gameOver = true;
    }

    /**
     * Returns current score
     * */
    public int getcscore ()
    {
        return cscore;
    }


    /**
     * Sets the score
     * @param cscore new score
     * */
    public void setcscore (int cscore)
    {
        this.cscore = cscore;
        if (cscore > rscore)
        {
            setLevel (level + 1);
            Application.getInstance().reset();
        }
    }

    /**
     * Adds to the current score
     * @param cscore delta score to add
     * */
    public void addcscore (int cscore)
    {
        setcscore (this.cscore + cscore);
    }

    /**
     * Returns the rscore value
     * @return value
     * */
    public int getrscore ()
    {
        return rscore;
    }

    /**
     * Sets rscore value
     * @param rscore value to set
     * */
    public void setrscore (int rscore)
    {
        this.rscore = rscore;
    }

    /**
     * Return bool gameOver
     * @return bool indicating whether the game is over
     * */
    public boolean isGameOver ()
    {
        return gameOver;
    }

    /**
     * Sets the bool wether the game is over
     * @param gameOver value
     * */
    public void setGameOver (boolean gameOver)
    {
        this.gameOver = gameOver;
    }

    /**
     * Returns string representation of the object
     * @return string value
     * */
    @Override
    public String toString ()
    {
        return "Current level=" + this.getLevel ()
                + " Remaining lives=" + this.getLives ()
                + " Remaining time=" + this.getClock ()
                + " Current score=" + this.getcscore ()
                + " Required score=" + this.getrscore ();
    }
}
