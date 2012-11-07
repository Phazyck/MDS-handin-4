package taskmanager.local;

import concurrent.AutoSave;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import javax.xml.bind.*;
import serialization.*;
import taskmanager.TaskManager;
import static serialization.util.Serializer.*;

/**
 * A TaskManager which manages its content locally in an asynchronous manner.
 */
public class LocalManager implements TaskManager {

    private final Cal cal;

    /**
     * TODO
     */
    public LocalManager() {
        this("./lib/task-manager-revised.xml");
    }

    /**
     * Uses a xml from a certain path.
     *
     * @param path
     */
    public LocalManager(String path) {
        Cal c = null;
        try (FileInputStream stream = new FileInputStream(path)) {
            JAXBContext context = JAXBContext.newInstance(Cal.class);
            c = (Cal) context.createUnmarshaller().unmarshal(stream);
        } catch (JAXBException | IOException ex) {
            System.out.println(ex);
        }
        Executors.newSingleThreadExecutor().execute(new AutoSave(c, path, 5));
        this.cal = c == null ? new Cal() : c;
    }

    @Override
    public boolean executeTask(String taskId) {
        Task task = getTask(taskId);

        if(task == null) {
            return false;
        }
        
        // Check if all conditions are satisfied...
        for (String cid : task.conditionsAsList()) {
            Task condition = getTask(cid);
            if (!condition.isExecuted() || condition.isRequired()) {
                // ..if not, the task can't be executed.
                return false;
            }
        }

        // Execute the task.
        synchronized (task) {
            task.setExecuted(true);
            task.setRequired(false);
        }

        // Update the response tasks.
        for (String rid : task.responsesAsList()) {
            Task response = getTask(rid);
            synchronized (response) {
                response.setRequired(true);
            }
        }

        return true;
    }

    @Override
    public Users getUsers() {
        return cal.users;
    }

    /**
     * Gets all tasks attended by a certain user.
     * If null or an empty string is used, all tasks are returned.
     *
     * @param attendantId The id of the user.
     * @return The attendants tasks.
     */
    @Override
    public Tasks getAttendantTasks(String attendantId) {
        if(attendantId == null || attendantId.trim().isEmpty()) {
            return cal.tasks;
        }
        
        List<Task> matches = new ArrayList<>();
        for (Task t : cal.tasks) {
            for(String attendant : t.attendantsAsList()) {
                if(attendant.equalsIgnoreCase(attendantId)) {
                    matches.add(t);
                }
            }
        }

        return new Tasks(matches);
    }

    @Override
    public Task getTask(String taskId) {
        for (Task t : cal.tasks) {
            if (t.id.equalsIgnoreCase(taskId)) {
                return t;
            }
        }
        return null;
    }
}
