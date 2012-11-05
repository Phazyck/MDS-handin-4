package taskmanager.local;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import serialization.*;
import taskmanager.TaskManager;

/**
 * A TaskManager which manages its content locally in an asynchronous manner.
 */
public class LocalManager implements TaskManager {

    private final String path;
    private Cal cal = new Cal(); 
    private FileInputStream streamIn;
    private FileOutputStream streamOut;
    
    /**
     * TODO
     */
    public LocalManager(){
        this("lib\task-manager-revised.xml");
    }
    
    /**
     * Uses a xml from a certain path. 
     * @param path 
     */
    public LocalManager(String p){
        path = p; 
        try {
            streamIn = new FileInputStream(path);
            streamOut = new FileOutputStream(path);
            cal = readCal();
        } catch (Exception e) {
            e.printStackTrace();
            cal = new Cal();
        }
    }
    
    private Cal readCal() throws JAXBException, FileNotFoundException{
        JAXBContext context = JAXBContext.newInstance(Cal.class);
        return (Cal) context.createUnmarshaller().unmarshal(streamIn);
        
    }
    
    private void writeCal() throws JAXBException, FileNotFoundException{
        JAXBContext context = JAXBContext.newInstance(Cal.class);
        context.createMarshaller().marshal(cal, streamOut);         
    }

    @Override
    public boolean executeTask(String taskId) {
        Task task = getTask(taskId);
        for(String s : task.conditionsAsList()){
            if(!getTask(s).isExecuted() || getTask(s).isRequired()){
                return false;
            } else{
                task.status = "executed";
                task.required = "false";
            }
        }         
              
        try {        
            writeCal();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return true;
    }

    @Override
    public Users getUsers() {
        return cal.users;    
    }

    @Override
    public Tasks getAttendantTasks(String attendantId) {
        List<Task> matches = new ArrayList<>();
        for(Task t : cal.tasks){
            if(t.attendantsAsList().contains(attendantId)) {
                matches.add(t);
            }
         }

        return new Tasks(matches);
    }

    @Override
    public Task getTask(String taskId) {
        for(Task t : cal.tasks){
            if (t.id.equals(taskId)){
                return t;           
            }
        }
        return null;
    }
}
