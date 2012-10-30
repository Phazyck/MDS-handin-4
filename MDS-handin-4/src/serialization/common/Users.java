package serialization.common;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Users implements Iterable<User> {
    @Override
    public Iterator<User> iterator() {
        return users.iterator();
    }
    
    List<User> users;
    
    public Users() {
        this(new ArrayList<User>());
    }
    
    public Users(List<User> users) {
        this.users = users;
    }

    public boolean isEmpty() {
        return users.isEmpty();        
    }    
}
