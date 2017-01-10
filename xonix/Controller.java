package xonix;

import xonix.dataclasses.*;
import xonix.modelclasses.ProxyModel;

import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineEvent.Type;


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
    Controller(Model model, View view)
    {
        this.model = model;
        this.view = view;
        this.model.addObserver(this.view);
    }

    /**
     * Updates only the mapView of the View attached to the controller
     * */
    public void updateMapView()
    {
        view.updateMapView(new ProxyModel(model));
    }

    /**
     * Updates only the scoreView of the View attached to the controller
     * */
    void updateScoreView()
    {
        view.updateScoreView(new ProxyModel(model));
    }

    /**
     * Updates the complete view attached to the controller
     * */
    public void updateView()
    {
        view.updateMapView(new ProxyModel(model));
        view.updateScoreView(new ProxyModel(model));
    }

    /**
     * Resets the model the controller owns
     */
    void resetModel()
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
        return (State)model.getState();
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

    /**
     * Returns the view of the controller
     * @return view
     * */
    public View getView()
    {
        return view;
    }
    /**
     * Returns the model of the controller
     * @return model
     */
    public Model getModel()
    {
        return model;
    }


    /**
     * Implements a way to play audio files
     * @param selectedClip the clip to play
     * */
    public static void playClip(Sounds selectedClip) throws IOException,
            UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        class AudioListener implements LineListener {
            private boolean done = false;
            @Override public synchronized void update(LineEvent event) {
                Type eventType = event.getType();
                if (eventType == Type.STOP || eventType == Type.CLOSE) {
                    done = true;
                    notifyAll();
                }
            }
            private synchronized void waitUntilDone() throws InterruptedException {
                while (!done) { wait(); }
            }
        }


        new Thread(() -> {
            AudioListener listener = new AudioListener();
            File f = new File(selectedClip.getClip());
            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f)) {
                DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
                Clip clip = (Clip)AudioSystem.getLine(info);
                clip.open(audioInputStream);
                try {
                    clip.start();
                    listener.waitUntilDone();
                } finally {
                    clip.close();
                }
            } catch (UnsupportedAudioFileException | IOException | InterruptedException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
