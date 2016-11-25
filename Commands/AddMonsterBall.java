package xonix.Commands;

import xonix.Application;
import xonix.constants.Constants;
import xonix.dataclasses.MonsterBall;

import java.awt.event.ActionEvent;

/**
 * Adds a monster ball to the game
 * */
public class AddMonsterBall extends Command {

    /**
     * Adds monsterball to the game
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Application.getInstance().getController().getModel().getMonsterBalls().add (
                new MonsterBall(
                        new java.awt.geom.Point2D.Float (
                                Application.getInstance().getController().getModel().getRandom().nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15,
                                Application.getInstance().getController().getModel().getRandom().nextInt (Constants.SQUARE_LENGTH * Constants.SQUARE_UNITS - 30) + 15),
                        Constants.MONSTER_COLOR,
                        Application.getInstance().getController().getModel().getRandom().nextInt (360),
                        Application.getInstance().getController().getModel().getRandom().nextFloat () * 100 + 10, 6)
        );
    }
}
