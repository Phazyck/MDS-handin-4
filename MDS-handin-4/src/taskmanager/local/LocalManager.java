package taskmanager.local;

import serialization.Task;
import serialization.Tasks;
import serialization.Users;
import taskmanager.TaskManager;

/**
 * A TaskManager which manages its content locally in an asynchronous manner.
 */
public class LocalManager implements TaskManager {

    /**
     * TODO
     */
    public LocalManager() {
        this("lib\task-manager-revised.xml");
    }
    
    /**
     * Uses a xml from a certain path. 
     * @param path 
     */
    public LocalManager(String path){
        
    }

    @Override
    public boolean executeTask(String taskId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Users getUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Tasks getAttendantTasks(String attendantId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Task getTask(String taskId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
