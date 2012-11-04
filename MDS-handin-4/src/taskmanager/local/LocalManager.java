
package taskmanager.local;

import serialization.Task;
import serialization.Tasks;
import serialization.Users;
import taskmanager.TaskManager;


public class LocalManager implements TaskManager {

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
