package org.frc1793.robot.commands;

import org.strongback.Strongback;
import org.strongback.command.Command;

/**
 * Created by tyler on 4/11/17.
 * An example of a command structure.
 */
public class ExampleCommand extends Command {
    private String word;

    public ExampleCommand(String word) {
        this.word = word;
    }
    
    @Override
    public boolean execute() {
        Strongback.logger().info(word);
        return true;
    }
}
