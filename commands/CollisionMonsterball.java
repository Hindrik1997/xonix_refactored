package xonix.commands;

import xonix.Application;
import xonix.dataclasses.MonsterBall;
import xonix.dataclasses.State;

import java.awt.event.ActionEvent;

public class CollisionMonsterball extends Command {
    private MonsterBall ball;

    public CollisionMonsterball(MonsterBall ball)
    {
        this.ball = ball;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        ((State)Application.getInstance().getController().getModel().getState()).decLives ();
        Application.getInstance().getController().getModel().removeMonsterBall(ball);
    }
}
