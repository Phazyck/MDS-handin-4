
package taskmanager.udp;

import serialization.common.Task;
import serialization.common.Tasks;
import serialization.common.Users;
import taskmanager.TaskManager;


public class UdpManagerClient implements TaskManager {

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
