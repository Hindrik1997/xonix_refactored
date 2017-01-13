package xonix;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public enum Sounds {
    TimeTicketCollision("powerup2.wav"),
    MonsterCollision("bleep.wav"),
    AddedScore("bleep.wav"),;

    private final String clip;
    Sounds(String s) {
        clip = s;
    }

    /***
     * Returns the clip to play
     * @return String representing the clip file name
     */
    private String getClip() {
        return clip;
    }

    /**
     * Implements a way to play audio files
     * */
    public void play() throws IOException,
            UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
        class AudioListener implements LineListener {
            private boolean done = false;
            @Override public synchronized void update(LineEvent event) {
                LineEvent.Type eventType = event.getType();
                if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
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
            File f = new File(this.getClip());
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