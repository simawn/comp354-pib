package command;

import java.util.ArrayList;

/**
 * Command manager that contains storeAndExecute(cmd) to execute and store commands
 * Also maintains a history of commands called.
 * 
 * @author David Gray
 */

public class CommandManager {
    private ArrayList<Command> history = new ArrayList<>();
    
    public void storeAndExecute(Command cmd) {
        this.history.add(cmd);
        cmd.execute();
    }
}
