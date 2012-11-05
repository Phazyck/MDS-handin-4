package taskmanager.remote;

import java.net.*;
import remote.Transmitter;
import remote.udp.UdpStringTransmitter;
import serialization.*;
import taskmanager.TaskManager;

/**
 * A TaskManager which manages its content remotely.
 */
public class RemoteManager implements TaskManager {

    private Transmitter<String> out;

    /**
     * Construct a RemoteManager which will communicate remotely through a
     * UdpStringTransceiver.
     */
    public RemoteManager() throws UnknownHostException, SocketException {
        this(null);
    }

    /**
     * Constructs a RemoteManager which will communicate remotely through a
     * given transceiver.
     *
     * @param out The string Transmitter which will enable the RemoteManager to
     * communicate with the RemoteManagerHost. Will use new
     * UdpStringTransmitter() if given 'null'.
     */
    public RemoteManager(Transmitter<String> out) throws UnknownHostException, SocketException {
        this.out = out == null ? new UdpStringTransmitter() : out;
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
