package xonix.commands;

import xonix.Application;
import xonix.Controller;
import xonix.Sounds;
import xonix.dataclasses.MonsterBall;
import xonix.dataclasses.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class CollisionMonsterball extends Command {
    private MonsterBall ball;

    public CollisionMonsterball(MonsterBall ball)
    {
        this.ball = ball;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        try {
            Controller.playClip(Sounds.MonsterCollision);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }

        (Application.getInstance().getController().getModel().getState()).decLives ();
        Application.getInstance().getController().getModel().removeMonsterBall(ball);
    }
}
