package xonix.Commands;

import xonix.Application;
import xonix.dataclasses.MonsterBall;

import java.awt.event.ActionEvent;

public class CollisionMonsterball extends Command {
    private MonsterBall ball;

    public CollisionMonsterball(MonsterBall ball)
    {
        this.ball = ball;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Application.getInstance().getController().getModel().getState().decLives ();
        Application.getInstance().getController().getModel().removeMonsterBall(ball);
    }
}
