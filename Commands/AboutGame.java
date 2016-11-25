package xonix.Commands;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Command showing the info box
 * */
public class AboutGame extends Command {
    /**
     * Shows the info box
     * */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JOptionPane.showMessageDialog(null, "Xonix: refactored, original code: Albert Sikkema, refactored version: Hindrik Stegenga", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
