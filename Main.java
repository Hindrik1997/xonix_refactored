package xonix;

/**
 * xonix.Main class of the application
 * Contains the main() function and is thus the entry point
 * */
public class Main {

    /**
     * Entry point of the program
     * */
    public static void main(String[] args){
        Application app = Application.getInstance();
        app.play();
    }
}
