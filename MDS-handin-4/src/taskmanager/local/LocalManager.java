package taskmanager.local;

import serialization.*;
import taskmanager.TaskManager;

/**
 * A TaskManager which manages its content locally in an asynchronous manner.
 */
public class LocalManager implements TaskManager {

    /**
     * TODO
     */
    public LocalManager() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * TODO
     *
     * @param threadLimit A limit on how many requests should be handled
     * asynchronously.
     */
    public LocalManager(int threadLimit) {
        throw new UnsupportedOperationException("Not supported yet.");
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
