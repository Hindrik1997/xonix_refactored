package xonix.dataclasses.Interfaces;

/**
 * State interface for proxy pattern
 * */
public interface IState {

    /**
     * Returns current level
     * @return current level
     * */
    int getLevel ();

    /**
     * Returns the clock float value
     * @return value
     * */
    float getClock ();

    /**
     * Returns amount of lives
     * @return amount of lives
     * */
    int getLives ();

    /**
     * Returns current score
     * */
    int getcscore ();

    /**
     * Returns the rscore value
     * @return value
     * */
    int getrscore ();

    /**
     * Return bool gameOver
     * @return bool indicating whether the game is over
     * */
    boolean isGameOver ();

    /**
     * Returns string representation of the object
     * @return string value
     * */
    @Override
    String toString ();

}
