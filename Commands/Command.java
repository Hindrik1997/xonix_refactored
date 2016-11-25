package xonix.Commands;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Implements the command pattern
 * */
public abstract class Command extends AbstractAction implements ActionListener {

    /**
     * Executes the command
     * Must be implemented by commands
     * */
    @Override
    public abstract void actionPerformed(ActionEvent actionEvent);
}