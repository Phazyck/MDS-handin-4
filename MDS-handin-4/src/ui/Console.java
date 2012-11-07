package ui;

import java.io.*;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.*;
import serialization.*;
import taskmanager.*;
import taskmanager.local.LocalManager;
import taskmanager.remote.RemoteManager;

/**
 * Provides interaction with a TaskManager through the terminal.
 */
public class Console implements Runnable {

    BufferedReader input;
    TaskManager manager;

    /**
     * Initializes the console with a little help from the user.
     */
    public Console() throws UnknownHostException, SocketException {
        input = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Which kind of TaskManager would you like to test?");
            System.out.println(" - [local]Manager");
            System.out.println(" - [remote]Manager");
            switch (in().toLowerCase()) {
                case "local":
                    manager = new LocalManager();
                    return;
                case "remote":
                    manager = new RemoteManager();
                    return;
                default:
                    wrongInput();
            }
        }
    }

    /**
     * Runs the Client.
     */
    @Override
    public void run() {
        while (true) {
            System.out.println("What would you like to do?");
            System.out.println(" - [execute] a task.");
            System.out.println(" - list all [users].");
            System.out.println(" - list all [tasks] attended by a given user.");
            System.out.println(" - display all details about a given [task].");
            System.out.println(" - [exit]");
            switch (in().toLowerCase()) {
                case "execute":
                    executeTask();
                    break;
                case "users":
                    listUsers();
                    break;
                case "tasks":
                    listTasks();
                    break;
                case "task":
                    displayTask();
                    break;
                default:
                    wrongInput();
            }
            System.out.println("==================================================");
        }
    }

    /**
     * Starts the [execute] dialog.
     */
    private void executeTask() {
        System.out.println("What is the id of the task you want to execute?");
        if(manager.executeTask(in())) {
            System.out.println("Task executed.");
        } else {
            System.out.println("Task couldn't be executed.");
            System.out.println("Some conditions might not have been fulfilled.");
        }
    }

    /**
     * Starts the [users] dialog.
     */
    private void listUsers() {
        System.out.println("Listing all users:");
        for (User u : manager.getUsers()) {
            System.out.println("  " + u.name);
        }
    }

    /**
     * Starts the [tasks] dialog.
     */
    private void listTasks() {
        System.out.println("What is the id of the attendant whose tasks you want to list?");
        String attendantId = in();
        Tasks tasks = manager.getAttendantTasks(attendantId);

        if (tasks.size() == 0) {
            System.out.println(attendantId + " isn't attending any tasks.");
        } else {
            System.out.println("Listing all attended tasks:");
            for (Task t : tasks) {
                System.out.println("  " + t.id);
            }
        }
    }

    /**
     * Starts the [task] dialog.
     */
    private void displayTask() {
        System.out.println("What is the id of the task you want to display?");

        Task task = manager.getTask(in());

        if (task != null) {
            System.out.println("Displaying " + task.id.trim() + ":");
            System.out.println("name:");
            System.out.println("  " + task.name.trim());
            System.out.println("date:");
            System.out.println("  " + task.date.trim());
            System.out.println("status:");
            System.out.println("  " + task.status.trim());
            System.out.println("required:");
            System.out.println("  " + task.required.trim());
            System.out.println("description:");
            System.out.println("  " + task.description.trim());
            System.out.println("attendants:");
            System.out.println("  " + task.attendants.trim());
            System.out.println("conditions:");
            System.out.println("  " + task.conditions.trim());
            System.out.println("responses:");
            System.out.println("  " + task.responses.trim());
        } else {
            System.out.println("No such task.");
        }
    }

    /**
     * Gets input from the user.
     *
     * @return The input.
     */
    private String in() {
        System.out.print("> ");
        System.out.flush();
        try {
            String line = input.readLine();
            if (line.equalsIgnoreCase("exit")) {
                System.out.println("Bye-bye!");
                System.exit(0);
            }
            return line;
        } catch (IOException ex) {
            return ex.toString();
        }
    }

    /**
     * A dialog which is started when unknown input is entered.
     */
    private void wrongInput() {
        System.out.println("Please type one of the options displayed in square brackets.");
        System.out.println("You can also [exit] when you're done.\n");
    }

    /**
     * Starts the TaskManager testing console.
     *
     * @param args Not used.
     */
    public static void main(String[] args) throws UnknownHostException, SocketException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new Console());
        exec.shutdown();
    }
}
