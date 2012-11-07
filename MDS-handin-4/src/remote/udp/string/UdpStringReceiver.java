package remote.udp.string;

import java.io.*;
import java.net.*;
import remote.Receiver;
import remote.Transmitter;

/**
 * A receiver which receives Strings through UDP.
 */
public class UdpStringReceiver implements Receiver<String> {

    private final DatagramSocket socket;
    private final byte[] buffer = new byte[65508];
    private DatagramPacket latest;

    /**
     * Constructs a UdpReceiver with port = 4444 and bufferLength = 256.
     *
     * @throws SocketException if the socket could not be opened, or the socket
     * could not bind to the specified local port.
     */
    public UdpStringReceiver() throws SocketException {
        this(new DatagramSocket(4444));
    }

    /**
     * Constructs a UdpReceiver.
     *
     * @param socket The socket on which the receiver should listen for messages.
     * @throws SocketException if the socket could not be opened, or the socket
     * could not bind to the specified local port.
     */
    public UdpStringReceiver(DatagramSocket socket) throws SocketException {
        this.socket = socket;
    }    

    /**
     * Receive a string from a transmitter.
     *
     * @return The string.
     */
    @Override
    public String receive() {
        latest = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(latest);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        String message = new String(latest.getData(), 0, latest.getLength());
        System.out.println("Message received: " + message);
        return message;
    }  

    @Override
    public Transmitter<String> getTransmitter() {
        try {
            return new UdpStringTransmitter(latest);
        } catch (SocketException ex) {
            System.out.println(ex);
            return null;
        }
    }
}