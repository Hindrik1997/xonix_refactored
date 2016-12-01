package xonix.commands;

import xonix.Application;
import xonix.dataclasses.MonsterBall;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class SwitchStrategies extends Command {

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ArrayList<MonsterBall> list = Application.getInstance().getController().getMonsterBalls();
        for(MonsterBall mb : list)
        {
            mb.rollNewStrategy();
        }
    }
}
