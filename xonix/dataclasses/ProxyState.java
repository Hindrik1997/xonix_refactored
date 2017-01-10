package xonix.dataclasses;

import xonix.dataclasses.Interfaces.IState;

/**
 * Proxy Class
 * */
public class ProxyState implements IState {

    IState state;

    public ProxyState(IState state)
    {
        this.state = state;
    }

    /**
     * Returns current level
     * @return current level
     * */
    public int getLevel ()
    {
        return state.getLevel();
    }

    /**
     * Returns the clock float value
     * @return value
     * */
    public float getClock ()
    {
        return state.getClock();
    }


    /**
     * Returns amount of lives
     * @return amount of lives
     * */
    public int getLives ()
    {
        return state.getLives();
    }

    /**
     * Returns current score
     * */
    public int getcscore ()
    {
        return state.getcscore();
    }


    /**
     * Returns the rscore value
     * @return value
     * */
    public int getrscore ()
    {
        return state.getrscore();
    }


    /**
     * Return bool gameOver
     * @return bool indicating whether the game is over
     * */
    public boolean isGameOver ()
    {
        return state.isGameOver();
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
