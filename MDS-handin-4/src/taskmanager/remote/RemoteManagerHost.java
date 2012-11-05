package taskmanager.remote;

import java.net.SocketException;
import remote.Receiver;
import remote.udp.UdpStringReceiver;
import taskmanager.TaskManager;
import taskmanager.local.LocalManager;

/**
 * A host to RemoteManagers content.
 */
public class RemoteManagerHost {

    private TaskManager manager;
    private Receiver<String> i;

    /**
     * Constructs a RemoteManagerHost which hosts a LocalManager through UDP.
     */
    public RemoteManagerHost() throws SocketException {
        this(null, null);
    }

    /**
     * Constructs a RemoteManagerHost with a specific TaskManager and string
     * Receiver.
     *
     * @param manager The TaskManager which should be hosted. Will use new
     * LocalManager() if given 'null'.
     * @param i The string Receiver which should be used to receive messages.
     * Will use new UdpStringReceiver() if given 'null'.
     */
    public RemoteManagerHost(TaskManager manager, Receiver<String> i) throws SocketException {
        this.manager = manager == null ? new LocalManager() : manager;
        this.i = i == null ? new UdpStringReceiver() : i;
    }
}
