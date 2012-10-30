
package serialization.common;

import java.util.*;


public class Tasks implements Iterable<Task> {

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }
    
    List<Task> tasks;
    
    public Tasks() {
        this(new ArrayList<Task>());
    }
    
    public Tasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();        
    }
}
