package xonix.constants;

/**
 * Class containing all application constants
 * */
public class Constants {

    public static final int SQUARE_LENGTH = 102;
    public static final int SQUARE_UNITS = 5;
    public static final int GAME_TICK_DELAY = 40;
    public static final java.awt.Color NO_COLOR = java.awt.Color.white;
    public static final java.awt.Color CAR_COLOR = java.awt.Color.red;
    public static final java.awt.Color SQUARE_COLOR = java.awt.Color.black;
    public static final java.awt.Color LINE_COLOR = java.awt.Color.red.darker ().darker ();
    public static final java.awt.Color PLAYER_COLOR = java.awt.Color.cyan;
    public static final java.awt.Color MONSTER_COLOR = java.awt.Color.orange;
    public static final java.awt.Color TICKET_COLOR = java.awt.Color.green;
    public static final int LEVEL_START = 1;
    public static final int TTIME_START = 6 - LEVEL_START;
    public static final int CLOCK_START = TTIME_START * 2;
    public static final int LIVES_START = 3;
    public static final int CSCORE_START = 0;
    public static final int RSCORE_START = (40 + LEVEL_START * 10) * 100;

}
