package command;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class CommandManager {
    private ArrayList<Command> history = new ArrayList<>();
    
    public void storeAndExecute(Command cmd) {
        this.history.add(cmd);
        cmd.execute();
    }
}
