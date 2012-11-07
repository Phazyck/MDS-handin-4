package taskmanager.local;

import concurrent.AutoSave;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import javax.xml.bind.*;
import serialization.*;
import taskmanager.TaskManager;

/**
 * A thread-safe TaskManager which manages its content locally.
 */
public class LocalManager implements TaskManager {

    private final Cal cal;   
    private final int SLEEP = 0;

    /**
     * Initializes itself by fetching required data from
     * "./lib/task-manager-revised.xml".
     */
    public LocalManager() {
        this("./lib/task-manager-revised.xml");
    }

    /**
     * Initializes itself by fetching required data from the path.
     *
     * @param path The path to the .xml-file which contains the data.
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

        if (task == null) {
            return false;
        }

        synchronized (task) {
            // Check if all conditions are satisfied...
            for (String cid : task.conditionsAsList()) {
                Task condition = getTask(cid);
                synchronized (condition) {
                    if (!condition.isExecuted() || condition.isRequired()) {
                        // ..if not, the task can't be executed.
                        return false;
                    }
                }
            }

            task.setRequired(false);
            task.setExecuted(true);

            try {
                TimeUnit.SECONDS.sleep(SLEEP);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted: " + ex);
            }



            // Update the response tasks.
            for (String rid : task.responsesAsList()) {
                Task response = getTask(rid);
                synchronized (response) {
                    response.setRequired(true);
                }
            }
        }
        return true;
    }

    @Override
    public Users getUsers() {
        return cal.users;
    }

    /**
     * Gets all tasks attended by a certain user. If null or an empty string is
     * used, all tasks are returned.
     *
     * @param attendantId The id of the user.
     * @return The attendants tasks.
     */
    @Override
    public Tasks getAttendantTasks(String attendantId) {
        if (attendantId == null || attendantId.trim().isEmpty()) {
            return cal.tasks;
        }

        List<Task> matches = new ArrayList<>();
        for (Task candidate : cal.tasks) {
            synchronized (candidate) {
                for (String attendant : candidate.attendantsAsList()) {
                    if (attendant.equalsIgnoreCase(attendantId)) {
                        matches.add(candidate);
                    }
                }
            }
        }

        return new Tasks(matches);
    }

    @Override
    public Task getTask(String taskId) {
        for (Task candidate : cal.tasks) {
            synchronized (candidate) {
                if (candidate.id.equalsIgnoreCase(taskId)) {
                    return candidate;
                }
            }
        }
        return null;
    }
}
